package mdc;

/**
 * Created by lcj on 15-9-22.
 */
public class AppContext {

    private static ThreadLocal<String> site = new ThreadLocal<String>();


    public static String getSite(){
        return site.get();
    }

    public static void setSite(String site1){
        site.set(site1);
    }
}


class newThread extends  Thread{
    @Override
    public void run() {
        System.out.println(AppContext.getSite());
    }
}