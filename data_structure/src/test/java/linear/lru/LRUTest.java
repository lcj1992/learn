package linear.lru;

import linear.lru.LRUBaseLinkedList;
import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 下午4:45
 */
public class LRUTest {

    @Test
    public void test() throws Exception {
        LRUBaseLinkedList<Integer> lru = new LRUBaseLinkedList<>();
        lru.add(1);
        lru.add(2);
        System.out.println(lru);
        lru.add(3);
        lru.add(4);
        lru.add(5);
        System.out.println(lru);
        lru.add(4);
        System.out.println(lru);
        lru.add(6);
        System.out.println(lru);
        lru.add(7);
        System.out.println(lru);
        lru.add(3);
        System.out.println(lru);
    }

    @Test
    public void testCapacity() throws Exception {
        LRUBaseLinkedList<Integer> lru = new LRUBaseLinkedList<>(8);
        lru.add(1);
        lru.add(2);
        System.out.println(lru);
        lru.add(3);
        lru.add(4);
        lru.add(8);
        lru.add(9);
        lru.add(5);
        System.out.println(lru);
        lru.add(4);
        System.out.println(lru);
        lru.add(6);
        System.out.println(lru);
        lru.add(7);
        System.out.println(lru);
        lru.add(3);
        System.out.println(lru);
        lru.add(1);
        System.out.println(lru);
    }
}
