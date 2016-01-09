package deepInJvm.toolTest;

/**
 * Created by lcj on 15-6-8.
 */
public class MonitorThreadDeadLockTest {
    static class SynAddRunable implements Runnable{
        int a,b;
        public SynAddRunable(int a,int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(new SynAddRunable(1,2)).start();
            new Thread(new SynAddRunable(2,1)).start();
        }
    }
}