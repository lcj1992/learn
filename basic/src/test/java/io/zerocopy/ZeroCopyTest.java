package io.zerocopy;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ZeroCopyTest {

    private static final String FILE_PATH = "send_file";
    private static final String DEST_FILE_PATH = "received_file";
    private static final int PORT = 9999;

    @Test
    public void test() throws InterruptedException {
        new Thread(this::startServer).start();
        startClient();
        Thread.sleep(5000);
    }

    public void startServer() {
        try (
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                FileChannel fileChannel = FileChannel.open(Paths.get(DEST_FILE_PATH), StandardOpenOption.WRITE, StandardOpenOption.CREATE)
        ) {
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            //noinspection InfiniteLoopStatement
            while (true) {
                try (SocketChannel clientSocketChannel = serverSocketChannel.accept()) {
                    long position = fileChannel.size();
                    long count = Long.MAX_VALUE - position;
                    long received = fileChannel.transferFrom(clientSocketChannel, position, count);
                    System.out.println("Received: " + received + " bytes");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startClient() {
        try (
                FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
                FileChannel fileChannel = fileInputStream.getChannel(); SocketChannel socketChannel = SocketChannel.open()
        ) {
            socketChannel.connect(new InetSocketAddress(PORT));
            long position = 0;
            long count = fileChannel.size();
            long transferred = fileChannel.transferTo(position, count, socketChannel);
            System.out.println("Transferred: " + transferred + " bytes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
