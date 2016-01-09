package deepInJvm.memTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcj on 15-6-6.
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOom {
    static class OOMObject {

    }
    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
