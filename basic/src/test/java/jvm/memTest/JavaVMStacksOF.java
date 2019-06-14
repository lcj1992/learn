package jvm.memTest;

/**
 * Created by lcj on 15-6-6.
 * -Xss228k
 */
public class JavaVMStacksOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStacksOF oom = new JavaVMStacksOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack length:" + oom.stackLength);
            throw e;
        }
    }
}
