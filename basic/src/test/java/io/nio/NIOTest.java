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
import java.util.Set;
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
    private static final int SERVER_PORT = 7893;
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
        startClient();
        Thread.sleep(200000);
    }


    private void startServer() throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress(SERVER_PORT));
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while (!Thread.interrupted()) {
            if (selector.select() == 0) continue;

            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                }

                if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int numRead = client.read(buffer);
                    if (numRead > 0) {
                        buffer.flip();
                        byte[] data = new byte[numRead];
                        buffer.get(data);
                        System.out.println("server received: " + new String(data));
                        client.write(ByteBuffer.wrap(("Hi, client").getBytes()));
                        client.write(buffer);
                    }
                    if (numRead == -1) {
                        key.cancel();
                        client.close();
                    }
                }
                iterator.remove();
            }
        }
    }

    public void startClient() throws IOException, InterruptedException {
        String host = "localhost";
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress(host, SERVER_PORT));
        while (!sc.finishConnect()) {
            System.out.println("waiting for the connection to be established");
        }
        ByteBuffer buffer = ByteBuffer.wrap("Hello, Server!".getBytes());
        sc.write(buffer);
        buffer.clear();
        int numRead = sc.read(buffer);
        if (numRead > 0) {
            buffer.flip();
            byte[] data = new byte[numRead];
            buffer.get(data);
            System.out.println("client received: " + new String(data));
        }
        Thread.sleep(1000);
        sc.close();
    }

}
