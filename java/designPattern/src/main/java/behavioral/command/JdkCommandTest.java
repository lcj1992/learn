package behavioral.command;
/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/16
 * Time: 下午7:25
 */


interface Receiver {
    void action();
}

class ConcreteReceiver implements Receiver{

    @Override
    public void action() {
        System.out.println("I am father");
    }
}

class ConcreteThread implements Runnable{

    private Receiver receiver;

    public ConcreteThread(Receiver receiver) {
        this.receiver = receiver;
    }


    @Override
    public void run() {
        receiver.action();
    }
}

public class JdkCommandTest {
    public static void main(String[] args) {
        Receiver receiver = new ConcreteReceiver();
        Runnable runnable = new ConcreteThread(receiver);
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
