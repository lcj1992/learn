package behavioral.command;

import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 16/8/16
 * Time: 下午7:25
 */


public class JdkCommandTest {
    @Test
    public void test() {
        Receiver receiver = new ConcreteReceiver();
        Runnable runnable = new ConcreteThread(receiver);
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public interface Receiver {
        void action();
    }

    public static class ConcreteReceiver implements Receiver {

        @Override
        public void action() {
            System.out.println("I am father");
        }
    }

    public static class ConcreteThread implements Runnable {

        private final Receiver receiver;

        ConcreteThread(Receiver receiver) {
            this.receiver = receiver;
        }


        @Override
        public void run() {
            receiver.action();
        }
    }
}
