package proxy.dynamicProxy;

/**
 * Created by lcj on 15-9-13.
 */
public class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("增加图书方法.....");
    }
}
