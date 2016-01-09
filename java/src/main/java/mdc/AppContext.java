package mdc;

/**
 * Created by lcj on 15-9-22.
 */
public class AppContext {

    private static InheritableThreadLocal<String> site = new InheritableThreadLocal<String>();


    public String getSite(){
        return site.get();
    }

    public void setSite(String site){
        this.site.set(site);
    }
}
