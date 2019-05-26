package deepInJvm.toolTest;

/**
 * Created by lcj on 15-6-8.
 */
public class MonitorThreadBusyTest {


    public static void createBusyThread() {
        Thread thread = new Thread(() -> {
            while (true)
                ;
        }, "testBusyThread");
        thread.start();
    }

    public static void main(String[] args) throws Exception {
        createBusyThread();
    }
}
