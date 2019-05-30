package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/13
 * Time: 上午8:46
 */
public class NIOClient {
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