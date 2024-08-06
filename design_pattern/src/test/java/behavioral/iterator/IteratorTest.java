package behavioral.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcj on 15-10-31.
 */
public class IteratorTest {
    @Test
    public void test() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("d");
        list.add("c");
        list.add("b");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
