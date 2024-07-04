package lang.exception;

import org.junit.Test;

public class ExceptionTest {

    @Test
    public void test() throws ClassNotFoundException {
        throwCheckedException();
    }

    public void throwCheckedException() throws ClassNotFoundException {
        System.out.println("hello world!");
        throw new ClassNotFoundException();
    }
}
