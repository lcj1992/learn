package io.nio;

import org.junit.Test;

import java.io.IOException;
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
        server.initServer(SERVER_PORT);
        server.listen();
    }
}
