package io.bio;

import lombok.AllArgsConstructor;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/10
 * Time: 下午11:33
 */
public class BIOTest {
    private static final int PORT = 4343;

    @Test
    public void test() throws InterruptedException {
        // Socket 服务器端（简单的发送信息）
        new Thread(this::startServer).start();
        startClient();
        Thread.sleep(5000);
    }

    private void startServer() {
        // 指定了端口的构造函数，相当于执行了bind和listen
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (!Thread.interrupted()) {
                new Thread(new Handler(serverSocket.accept())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AllArgsConstructor
    public static class Handler implements Runnable {
        final Socket socket;

        public void run() {
            try {
                InputStream in = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                OutputStream out = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                String request;
                while ((request = reader.readLine()) != null) {
                    String response = processRequest(request);
                    writer.println(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String processRequest(String request) {
            System.out.println("received from client: " + request);
            return request.toUpperCase();
        }
    }

    private void startClient() {
        try (Socket socket = new Socket(InetAddress.getLocalHost(), PORT)) {
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            String message = "Hello, Server!";
            writer.println(message);
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            reader.lines().forEach(s -> System.out.println("received from server: " + s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
