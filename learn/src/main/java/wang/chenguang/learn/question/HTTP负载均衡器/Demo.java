package wang.chenguang.learn.question.HTTP负载均衡器;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    // 测试用例
    public static void main(String[] args) throws IOException {
        List<String> servers = new ArrayList<>();
        servers.add("backend-server1.com");
        servers.add("backend-server2.com");

        HttpLoadBalancer loadBalancer = new HttpLoadBalancer(servers);
        loadBalancer.start(8080);
    }
}
