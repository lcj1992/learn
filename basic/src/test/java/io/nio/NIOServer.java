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
        System.out.println("server started succeed!");
        while (true) {
            selector.select();
            Iterator<SelectionKey> ite = selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = ite.next();
                if (key.isAcceptable()) {
                    SocketChannel channel = serverSocketChannel.accept();
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    recvAndReply(key);
                }
                ite.remove();
            }
        }
    }

    private void recvAndReply(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(256);
        int i = channel.read(buffer);
        if (i != -1) { //用于判断客户端是否断开了连接
            String msg = new String(buffer.array()).trim();
            System.out.println("server received message: " + msg);
            System.out.println("server reply: " + msg);
            channel.write(ByteBuffer.wrap(msg.getBytes()));
        } else {
            channel.close(); //如果客户端断开连接就关闭该连接
        }

    }
}