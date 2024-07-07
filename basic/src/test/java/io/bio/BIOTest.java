package io.bio;

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
        startServer();
        readFromServer();
        Thread.sleep(5000000);
    }

    @SuppressWarnings({"InfiniteLoopStatement"})
    private void startServer() {
        Runnable runnable = () -> {
            // 指定了端口的构造函数，相当于执行了bind和listen
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                System.out.println("Server is listening on port " + PORT + "...");
                while (true) {
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected: " + socket.getInetAddress());
                    Thread t = new Thread(() -> {
                        try {
                            InputStream in = socket.getInputStream();
                            OutputStream out = socket.getOutputStream();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                            PrintWriter writer = new PrintWriter(out, true);
                            String request;
                            while ((request = reader.readLine()) != null) {
                                System.out.println("Received from client: " + request);
                                // Process the request here
                                String response = request.toUpperCase();
                                // Send the response back to the client
                                writer.println(response);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    t.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        new Thread(runnable).start();

    }

    private void readFromServer() {
        try (Socket socket = new Socket(InetAddress.getLocalHost(), PORT)) {
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            PrintWriter writer = new PrintWriter(out, true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String message = "Hello, Server!";
            writer.println(message);
            reader.lines().forEach(s -> System.out.println("客户端接收到：" + s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
