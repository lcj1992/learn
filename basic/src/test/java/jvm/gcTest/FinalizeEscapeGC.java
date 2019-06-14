package jvm.gcTest;

import org.junit.Test;

/**
 * Created by lcj on 15-6-7.
 */
public class FinalizeEscapeGC {

    private static FinalizeEscapeGC SAVE_HOOK = null;

    private void isAlive() {
        System.out.println("yes,i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    @Test
    public void test() throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i am dead :)");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i am dead :)");
        }
    }
}
