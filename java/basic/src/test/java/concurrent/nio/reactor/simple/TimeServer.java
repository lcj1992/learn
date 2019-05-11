package concurrent.nio.reactor.simple;

import java.io.IOException;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 16/9/8
 * Time: 上午10:41
 */
public class TimeServer {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
