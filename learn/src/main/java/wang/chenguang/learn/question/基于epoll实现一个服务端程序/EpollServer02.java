package wang.chenguang.learn.question.基于epoll实现一个服务端程序;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EpollServer02 {
    private static final int THREAD_POOL_SIZE = 4;
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("localhost", 8080));
        serverSocketChannel.configureBlocking(false);

        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            Selector selector = Selector.open();
            threadPool.submit(() -> {
                try {
                    while (true) {
                        selector.select();
                        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                        while (iterator.hasNext()) {
                            SelectionKey key = iterator.next();
                            iterator.remove();
                            if (key.isReadable()) {
                                ByteBuffer buffer = ByteBuffer.allocate(1024);
                                SocketChannel client = (SocketChannel) key.channel();
                                int bytesRead = client.read(buffer);
                                if (bytesRead == -1) {
                                    client.close();
                                } else {
                                    buffer.flip();
                                    // 对接收到的数据进行处理
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}