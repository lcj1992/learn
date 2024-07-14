package ds.queue;

import org.junit.Test;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    @Test
    public void test() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(10);
        queue.add(3);
        queue.add(20);
        while (!queue.isEmpty()) {
            Integer peek = queue.poll();
            System.out.println(peek);
        }
    }
}
