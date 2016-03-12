package deepInJvm.toolTest;

/**
 * Created by lcj on 15-6-8.
 */
public class MonitorThreadBusyTest {

    /**
     * 县城死循环演示
     */
    public static void createBusyThread(){
        Thread thread = new Thread(new Runnable() {

            public void run() {
                while(true)
                    ;
            }
        },"testBusyThread");
        thread.start();
    }



    public static void main(String[] args) throws Exception {
        createBusyThread();
    }
}
