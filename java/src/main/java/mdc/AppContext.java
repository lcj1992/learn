package mdc;

/**
 * Created by lcj on 15-9-22.
 */
public class AppContext {

    private static InheritableThreadLocal<String> site = new InheritableThreadLocal<String>();


    public static String getSite(){
        return site.get();
    }

    public static void setSite(String site1){
        site.set(site1);
    }
}
