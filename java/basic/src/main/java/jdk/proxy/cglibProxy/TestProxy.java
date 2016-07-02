package jdk.proxy.cglibProxy;

/**
 * Created by lcj on 15-9-13.
 */
public class TestProxy {
    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeImpl bookFacadeImpl = (BookFacadeImpl) cglib.getInstance(new BookFacadeImpl());
        bookFacadeImpl.addBook();
    }
}
