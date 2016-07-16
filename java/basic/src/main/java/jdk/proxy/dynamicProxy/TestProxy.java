package jdk.proxy.dynamicProxy;

/**
 * Created by lcj on 15-9-13.
 *
 */
public class TestProxy {

    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookFacade = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookFacade.addBook();
    }
}
