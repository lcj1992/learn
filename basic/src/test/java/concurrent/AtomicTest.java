package concurrent;

import com.google.common.collect.Lists;
import org.junit.Assert;
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
 * Author:foolchild
 * Date: 16/8/21
 * Time: 下午6:32
 */
public class AtomicTest {

    private static final int FINAL_VALUE = 100000;

    @Test
    public void atomicReferenceTest() {
        AtomicReference<Integer> atomicReference = new AtomicReference<>();
        atomicReference.set(10);
        Assert.assertEquals(atomicReference.compareAndSet(10, 11), true);
    }

    @Test
    public void atomicIntegerTest() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        List<Callable<Integer>> callableList = Lists.newArrayList();
        for (int i = 0; i < FINAL_VALUE; i++) {
            callableList.add(atomicInteger::getAndIncrement);
        }
        executorService.invokeAll(callableList);
        Assert.assertEquals(atomicInteger.get(), FINAL_VALUE);
    }

    private volatile Integer atomicInteger = 0;

    @Test
    public void volatileIntegerTest() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(30);
        List<Callable<Integer>> callableList = Lists.newArrayList();

        for (int i = 0; i < FINAL_VALUE; i++) {
            callableList.add(() -> atomicInteger++);
        }
        executorService.invokeAll(callableList);
        Assert.assertEquals(atomicInteger < FINAL_VALUE, true);
    }
}
