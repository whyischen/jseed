package wang.chenguang.learn.question.基于epoll实现一个服务端程序;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EpollServer03 {
    private static final int PORT = 8080;
    private static final int BUFFER_SIZE = 1024;
    private static final int MAX_THREADS = 8;

    private ExecutorService pool;
    private Selector selector;

    public EpollServer03() throws IOException {
        this.pool = Executors.newFixedThreadPool(MAX_THREADS);
        this.selector = Selector.open();

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new java.net.InetSocketAddress(PORT));
        serverChannel.configureBlocking(false);
        serverChannel.register(selector, serverChannel.validOps());
        System.out.println("Server started on port " + PORT);
    }

    public void run() throws IOException {
        while (true) {
            selector.select();
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iter = selectedKeys.iterator();
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                iter.remove();
                if (key.isAcceptable()) {
                    SocketChannel client = ((ServerSocketChannel) key.channel()).accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, ByteBuffer.allocate(BUFFER_SIZE));
                } else if (key.isReadable()) {
                    pool.execute(new RequestHandler((SocketChannel) key.channel(), selector));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EpollServer03().run();
    }

    private static class RequestHandler implements Runnable {
        private SocketChannel channel;
        private Selector selector;

        public RequestHandler(SocketChannel channel, Selector selector) {
            this.channel = channel;
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
                int bytesRead;
                while ((bytesRead = channel.read(buffer)) != -1) {
                    if (bytesRead > 0) {
                        String request = new String(buffer.array(), 0, bytesRead);
                        System.out.println(request);
                        // Echo the request back to the client
                        channel.write(ByteBuffer.wrap(request.getBytes()));
                    }
                    buffer.clear();
                }
                channel.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
