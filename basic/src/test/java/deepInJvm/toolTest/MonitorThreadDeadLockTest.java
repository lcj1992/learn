package deepInJvm.toolTest;

/**
 * Created by lcj on 15-6-8.
 */
public class MonitorThreadDeadLockTest {
    static class SynAddRunnable implements Runnable {
        private final Integer a;
        private final Integer b;


        SynAddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public void run() {
            synchronized (a) {
                synchronized (b) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new SynAddRunnable(1, 2)).start();
            new Thread(new SynAddRunnable(2, 1)).start();
        }
    }
}