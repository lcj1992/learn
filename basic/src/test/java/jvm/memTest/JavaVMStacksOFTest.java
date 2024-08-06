package jvm.memTest;

import org.junit.Test;

/**
 * Created by lcj on 15-6-6.
 * -Xss228k
 */
public class JavaVMStacksOFTest {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    @Test
    public void test() throws Throwable {
        JavaVMStacksOFTest oom = new JavaVMStacksOFTest();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack length:" + oom.stackLength);
            throw e;
        }
    }
}
