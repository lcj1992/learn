package reference;

import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2017/5/31
 * Time: 上午8:30
 */
public class ReferenceTest {

    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<>();

    private static void checkQueue() {
        Reference<? extends VeryBig> ref;
        while ((ref = rq.poll()) != null) {
            System.out.println("In queue: " + ((VeryBigWeakReference) (ref)).id);
        }
    }

    @Test
    public void test() {
        int size = 3;
        LinkedList<WeakReference<VeryBig>> weakList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            weakList.add(new VeryBigWeakReference(new VeryBig("" + i), rq));
            System.out.println("Just created weak obj: " + weakList.getLast().get().id);

        }

        // 触发gc，弱引用指向对象被回收；如果强引用指向last，则last不会被回收
//        VeryBig veryBig = weakList.getLast().get();
        System.gc();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkQueue();
    }
}

class VeryBig {
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

class VeryBigWeakReference extends WeakReference<VeryBig> {
    String id;

    VeryBigWeakReference(VeryBig big, ReferenceQueue<VeryBig> rq) {
        super(big, rq);
        this.id = big.id;
    }

    protected void finalize() {
        System.out.println("Finalizing VeryBigWeakReference " + id);
    }


}
