package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIOServer
 */
public class NIOServer {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    void initServer(int port) throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress("localhost", port));

        this.selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

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
            channel.write(ByteBuffer.wrap(("hello client, I receive you msg").getBytes()));
        } else {
            channel.close(); //如果客户端断开连接就关闭该连接
        }

    }
}