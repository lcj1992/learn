package lang.reference;

import org.junit.Test;

import java.lang.ref.*;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2017/5/31
 * Time: 上午8:30
 */
public class ReferenceTest {

    private static final ReferenceQueue<VeryBig> REFERENCE_QUEUE = new ReferenceQueue<>();

    @Test
    public void testStrongReference() {
        Object obj = new Object(); // 强引用
        System.out.println(obj);   // 输出对象的地址
        obj = null;                // 解除强引用
        System.gc();               // 请求垃圾回收
        System.out.println(obj);   // 输出null，因为引用已经被解除
    }

    @Test
    public void testSoftReference() {
        Object obj = new Object();
        SoftReference<Object> softRef = new SoftReference<>(obj);
        obj = null;                 // 解除强引用
        System.gc();                // 请求垃圾回收
        System.out.println(softRef.get()); // 输出可能为null，也可能为对象地址，取决于内存状况
    }

    @Test
    public void testWeakReference() {
        Object obj = new Object();
        WeakReference<Object> weakRef = new WeakReference<>(obj);
        obj = null;                  // 解除强引用
        System.gc();                 // 请求垃圾回收
        System.out.println(weakRef.get()); // 输出null，因为弱引用已经被回收
    }

    @Test
    public void testPhantomReference() {
        Object obj = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> phantomRef = new PhantomReference<>(obj, queue);
        obj = null;                   // 解除强引用
        System.gc();                  // 请求垃圾回收
        System.out.println(phantomRef.get()); // 输出null，因为虚引用不能获取对象实例
        System.out.println(queue.poll());     // 输出虚引用，表示对象已被回收
    }

    @Test
    public void test() {
        int size = 3;
        LinkedList<WeakReference<VeryBig>> weakList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            weakList.add(new VeryBigWeakReference(new VeryBig("" + i), REFERENCE_QUEUE));
            System.out.println("Just created weak obj: " + Objects.requireNonNull(weakList.getLast().get()).id);

        }

        // 触发gc，弱引用指向对象被回收；如果强引用指向last，则last不会被回收
        VeryBig veryBig = weakList.getLast().get();
        System.gc();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkQueue();
    }

    static class VeryBig {
        String id;
        // 占用空间,让线程进行回收
        byte[] b = new byte[2 * 1024];

        VeryBig(String id) {
            this.id = id;
        }

        protected void finalize() {
            System.out.println("Finalizing VeryBig " + id);
        }
    }

    static class VeryBigWeakReference extends WeakReference<VeryBig> {
        String id;

        VeryBigWeakReference(VeryBig big, ReferenceQueue<VeryBig> rq) {
            super(big, rq);
            this.id = big.id;
        }

        protected void finalize() {
            System.out.println("Finalizing VeryBigWeakReference " + id);
        }
    }

    private static void checkQueue() {
        Reference<? extends VeryBig> ref;
        while ((ref = REFERENCE_QUEUE.poll()) != null) {
            System.out.println("In queue: " + ((VeryBigWeakReference) (ref)).id);
        }
    }
}
