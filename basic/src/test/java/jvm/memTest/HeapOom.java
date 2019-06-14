package jvm.memTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcj on 15-6-6.
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOom {
    static class OOMObject {

    }

    @Test
    public void test() {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
