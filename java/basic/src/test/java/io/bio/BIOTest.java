package io.bio;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
    private static final int PORT_8080 = 8080;

    @Test
    public void test() throws InterruptedException {
        // Socket 服务器端（简单的发送信息）
        startServer();
        Thread.sleep(1000);
        readFromServer();
        readFromServer();
        readFromServer();
        Thread.sleep(2000000);
    }


    @Test
    public void testHttpServer() {
        try {
            ServerSocket serverConnect = new ServerSocket(PORT_8080);
            System.out.println("Server started.\nListening for connections on port : " + PORT_8080 + " ...\n");

            // we listen until user halts server execution
            while (true) {
                JavaHttpServer myServer = new JavaHttpServer(serverConnect.accept());

                // create dedicated thread to manage the client connection
                Thread thread = new Thread(myServer);
                thread.setDaemon(true);
                thread.start();
            }
        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        }
    }

    private void readFromServer() {
        try (Socket cSocket = new Socket(InetAddress.getLocalHost(), PORT)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println("客户端：" + s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startServer() {
        Runnable runnable = () -> {
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                while (true) {
                    Socket socket = serverSocket.accept();
                    try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream())) {
                        printWriter.println("hello world！");
                        printWriter.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Thread sThread = new Thread(runnable);
        sThread.start();
    }
}
