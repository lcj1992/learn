package util.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        Integer i = list.get(0);
        System.out.println(i);
    }
}
