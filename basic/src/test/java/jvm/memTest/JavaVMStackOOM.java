package jvm.memTest;

import org.junit.Test;

/**
 * Created by lcj on 15-6-6.
 * -Xss8M
 */
public class JavaVMStackOOM {
    private void doNotStop() {
        while (true) {
        }
    }

    private void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(this::doNotStop);
            thread.start();
        }
    }

    @Test
    public void test() {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
