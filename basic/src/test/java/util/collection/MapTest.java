package util.collection;

import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

public class MapTest {

    @Test
    public void testTreeMap() {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.put(3, 1);
        map.put(5, 1);
        map.put(7, 1);
        SortedMap<Integer, Integer> res = map.tailMap(3);
        System.out.println(res);
    }
}
