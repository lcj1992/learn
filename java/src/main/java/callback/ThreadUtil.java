package callback;

/**
 * Created by lcj on 15-5-9.
 */
public class ThreadUtil {
    public static void sleep(long mills){
        try{
            Thread.sleep(mills);
        } catch (InterruptedException e) {
        }
    }
}
