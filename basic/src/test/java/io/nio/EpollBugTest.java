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

public class EpollBugTest {

    @Test
    public void test() throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8080);
        socketChannel.bind(inetSocketAddress);
        socketChannel.configureBlocking(false);
        int ops = socketChannel.validOps();
        socketChannel.register(selector, ops, null);
        Set<SelectionKey> selectedKeys = selector.selectedKeys();
        //noinspection InfiniteLoopStatement
        while (true) {
            System.out.println("waiting...");
            /*
              在epoll空轮询的bug中，之前处于连接状态突然被断开，没什么可select时，select()应该阻塞，
              但在此bug中，select()被唤醒，而实际又没有数据传入，导致while(itr.hasNext())根本不会执行，而后就进入while的死循环，cpu自然很快飙升到100%状态。
              也即，预期内应该只输出一个"waiting..."，但实际会不断的输出"waiting..."。
             */
            int noOfKeys = selector.select();
            System.out.println("selected keys:" + noOfKeys);
            Iterator<SelectionKey> itr = selectedKeys.iterator();
            while (itr.hasNext()) {
                SelectionKey key = itr.next();
                if (key.isAcceptable()) {
                    SocketChannel client = socketChannel.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println("The new connection is accepted from the client: " + client);
                } else if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    client.read(buffer);
                    String output = new String(buffer.array()).trim();
                    System.out.println("Message read from client: " + output);
                    if (output.equals("Bye Bye")) {
                        client.close();
                        System.out.println("The Client messages are complete; close the session.");
                    }
                }
                itr.remove();
            }
        }
    }
}
