package behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcj on 15-10-31.
 */
public class IteratorTest {
    public static void main(String[] args) {
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
