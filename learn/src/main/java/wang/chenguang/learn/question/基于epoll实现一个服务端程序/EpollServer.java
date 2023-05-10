package wang.chenguang.learn.question.基于epoll实现一个服务端程序;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EpollServer {
    private Selector selector;
    private ExecutorService executor;

    public void start(int port, int workerNum) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress(port));
        serverChannel.configureBlocking(false);

        selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        executor = Executors.newFixedThreadPool(workerNum);
        for (int i = 0; i < workerNum; i++) {
            executor.submit(new Worker());
        }

        while (true) {
            int count = selector.select();
            if (count > 0) {
                for (SelectionKey key : selector.selectedKeys()) {
                    if (key.isAcceptable()) {
                        SocketChannel clientChannel = serverChannel.accept();
                        clientChannel.configureBlocking(false);
                        clientChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int len = clientChannel.read(buffer);
                        if (len > 0) {
                            buffer.flip();
                            byte[] data = new byte[buffer.remaining()];
                            buffer.get(data);
                            // 处理读取到的数据
                            executor.execute(new ProcessTask(data));
                        } else {
                            clientChannel.close();
                        }
                    }
                    selector.selectedKeys().remove(key);
                }
            }
        }
    }

    class Worker implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    int count = selector.select();
                    if (count > 0) {
                        for (SelectionKey key : selector.selectedKeys()) {
                            if (key.isWritable()) {
                                // 处理可写事件
                            } else if (key.isReadable()) {
                                // 处理可读事件
                            } else if (key.isConnectable()) {
                                // 处理连接事件
                            } else if (key.isAcceptable()) {
                                // 处理接受连接事件
                            }
                            selector.selectedKeys().remove(key);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ProcessTask implements Runnable {
        private byte[] data;

        public ProcessTask(byte[] data) {
            this.data = data;
        }

        @Override
        public void run() {
            // 处理读取到的数据
        }
    }
}
