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

    @Test
    public void test() throws InterruptedException {
        // Socket 服务器端（简单的发送信息）
        startServer();

        readFromServer();
    }

    private void startServer() {
        Runnable runnable = () -> {
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                while (true) {
                    Socket socket = serverSocket.accept();
                    try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream())) {
                        printWriter.println("hello world, 呵呵");
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

    private void readFromServer() {
        try (Socket cSocket = new Socket(InetAddress.getLocalHost(), PORT)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println("客户端接收到：" + s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
