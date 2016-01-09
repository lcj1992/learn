package deepInJvm.toolTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcj on 15-6-8.
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class MonitorMemoryTest {
    static class OOMObject{
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException{
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            //稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
        Thread.sleep(10000000L);
    }
}
