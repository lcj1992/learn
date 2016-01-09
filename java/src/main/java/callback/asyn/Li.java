package callback.asyn;

import learn.java.callback.CallBack;
import learn.java.callback.ThreadUtil;

/**
 * Created by lcj on 15-5-9. 故事背景： 小王在做寒假作业，碰到了一道题不会，发短信问学霸小李，小李刚好在洗澡，小王等啊等，等不及了就去逛街了
 */
public class Li {
    public void executeMessage(CallBack callBack, String question) {
        //Thread.sleep 15s 模拟小李在洗澡
        System.out.println("刚好小李在洗澡，没看到短信");
        ThreadUtil.sleep(20000);
        System.out.print("小李洗完澡后看到短信，告诉小王的答案是--->");
        callBack.solve("2");
    }

}
