package concurrent;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/21
 * Time: 下午6:32
 */
public class AtomicTest {

    @Test
    public void AtomicReferenceTest() {
        AtomicReference<Integer> atomicReference = new AtomicReference<>();
        atomicReference.set(10);
        System.out.println(atomicReference.compareAndSet(10, 10));
    }

    @Test
    public void atomicIntegerTest() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        List<Callable<Integer>> callableList = Lists.newArrayList();
        for (int i = 0; i < 10000000; i++) {
            callableList.add(atomicInteger::getAndIncrement);
        }
        executorService.invokeAll(callableList);
        System.out.println(atomicInteger.get());
    }


    volatile Integer atomicInteger = 0;
    @Test
    public void volatileIntegerTest() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(30);
        List<Callable<Integer>> callableList = Lists.newArrayList();
        for (int i = 0; i < 10000000; i++) {
            callableList.add(()-> atomicInteger++);
        }
        executorService.invokeAll(callableList);
        System.out.println(atomicInteger);
    }

    @Test
    public void test() {
        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("ab");
        boolean ok = list.stream().filter(s -> s.length() > 1).count() > 0;
        System.out.println(ok);
    }
}
