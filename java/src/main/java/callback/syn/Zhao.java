package callback.syn;

import learn.java.callback.CallBack;
import learn.java.callback.ThreadUtil;

/**
 * Created by lcj on 15-5-9.
 */
public class Zhao {
    public void executeMessage(CallBack callBack, String question) {
        System.out.println("刚好小赵也不会，于是小赵就google，帮小孙找答案（期间小孙不能挂电话，只能等着小赵找到答案）");
        ThreadUtil.sleep(20000);
        System.out.print("小赵找到了答案，告诉小孙的答案是--->");
        callBack.solve("2");
    }
}
