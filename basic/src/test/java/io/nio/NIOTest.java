package io.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/13
 * Time: 上午8:47
 */
public class NIOTest {
    private static final int SERVER_PORT = 7788;
    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();

    @Test
    public void testNIO() throws Exception {
        EXECUTOR.submit(() -> {
            try {
                startServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread.sleep(1000);
        NIOClient client = newClient();
        client.sendAndRecv("this is client");
        Thread.sleep(200000);
    }

    private NIOClient newClient() throws IOException {
        NIOClient client = new NIOClient();
        client.initClient("localhost", SERVER_PORT);
        return client;
    }

    private void startServer() throws IOException {
        NIOServer server = new NIOServer();
        server.initServer();
        server.listen();
    }

    public static class NIOServer {
        private Selector selector;
        private ServerSocketChannel serverSocketChannel;

        void initServer() throws IOException {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress("localhost", SERVER_PORT));

            this.selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        }

        @SuppressWarnings("InfiniteLoopStatement")
        void listen() throws IOException {
            while (true) {
                selector.select();
                Iterator<SelectionKey> ite = selector.selectedKeys().iterator();
                while (ite.hasNext()) {
                    SelectionKey key = ite.next();
                    if (key.isAcceptable()) {
                        SocketChannel channel = serverSocketChannel.accept();
                        channel.configureBlocking(false);
                        channel.register(selector, SelectionKey.OP_READ);
                    }
                    if (key.isReadable()) {
                        recvAndReply(key);
                    }
                    if (key.isWritable()) {
                        //do something
                        System.out.println("key is writable");
                    }
                    if (key.isConnectable()) {
                        //do something
                        System.out.println("key is connectable");
                    }
                    ite.remove();
                }
            }
        }

        private void recvAndReply(SelectionKey key) throws IOException {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(2048);
            int i = channel.read(buffer);
            if (i != -1) { //用于判断客户端是否断开了连接
                String msg = new String(buffer.array()).trim();
                channel.write(ByteBuffer.wrap(("hello client, I receive you msg" + msg).getBytes()));
            } else {
                channel.close(); //如果客户端断开连接就关闭该连接
            }

        }
    }


    public static class NIOClient {
        private SocketChannel channel;

        public void initClient(String host, int port) throws IOException {
            InetSocketAddress servAddr = new InetSocketAddress(host, port);
            this.channel = SocketChannel.open(servAddr);
        }

        public void sendAndRecv(String words) throws IOException {
            byte[] msg = words.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(msg);
            System.out.println("sending: " + words);
            channel.write(buffer);
            buffer.clear();

            channel.read(buffer);
            System.out.println("received: " + new String(buffer.array()).trim());
            buffer.clear();

            channel.close();
        }
    }
}
