package wang.chenguang.learn.question.HTTP负载均衡器;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class HttpLoadBalancer {
    private static final AtomicInteger CURRENT_SERVER_INDEX = new AtomicInteger(0);
    private static final CopyOnWriteArrayList<String> SERVER_LIST = new CopyOnWriteArrayList<>();

    public HttpLoadBalancer(List<String> servers) {
        SERVER_LIST.addAll(servers);
    }

    public void start(int port) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(port), 0);
        httpServer.createContext("/", new LoadBalancerHandler());
        httpServer.setExecutor(Executors.newFixedThreadPool(4));
        httpServer.start();

        // 启动健康检查线程
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
                HttpLoadBalancer::healthCheck, 0, 10, TimeUnit.SECONDS);
    }

    static class LoadBalancerHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            int serverIndex = getNextServerIndex();
            String targetServer = SERVER_LIST.get(serverIndex);
            HttpClient client = HttpClient.newHttpClient();
            URI targetURI = URI.create(targetServer + exchange.getRequestURI());

            HttpRequest.Builder requestBuilder = HttpRequest.newBuilder(targetURI)
                    .method(exchange.getRequestMethod(), HttpRequest.BodyPublishers.noBody());

            // 转发请求
            HttpResponse<String> response;
            try {
                response = client.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString());
                exchange.sendResponseHeaders(response.statusCode(), response.body().length());
                exchange.getResponseBody().write(response.body().getBytes());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                exchange.close();
            }
        }
    }

    public static void addBackendServer(String serverUrl) {
        SERVER_LIST.add(serverUrl);
    }

    public static void removeBackendServer(String serverUrl) {
        SERVER_LIST.remove(serverUrl);
    }

    private static int getNextServerIndex() {
        return CURRENT_SERVER_INDEX.getAndUpdate(n -> (n + 1) % SERVER_LIST.size());
    }

    private static void healthCheck() {
        for (String server : SERVER_LIST) {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URI(server + "/health").toURL().openConnection();
                connection.setConnectTimeout(3000);
                connection.setReadTimeout(3000);
                int statusCode = connection.getResponseCode();
                if (statusCode != 200) {
                    System.out.println("Server " + server + " is unhealthy, removing from the load balancer");
                    removeBackendServer(server);
                }
            } catch (Exception e) {
                System.out.println("Server " + server + " is unhealthy, removing from the load balancer");
                removeBackendServer(server);
            }
        }
    }
}
