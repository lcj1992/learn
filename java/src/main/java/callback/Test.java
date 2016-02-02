package callback;

import callback.asyn.Li;
import callback.asyn.Wang;
import callback.syn.Sun;
import callback.syn.Zhao;

/**
 * Created by lcj on 15-5-9. http://blog.csdn.net/xiaanming/article/details/8703708
 */




public class Test {
    public static void main(String[] args) throws InterruptedException {
        Li li = new Li();
        Wang wang = new Wang(li);
        wang.askQuestion("1 + 1 = ?");
        ThreadUtil.sleep(20000);
        Zhao zhao = new Zhao();
        Sun sun = new Sun(zhao);
        sun.askQuestion("1 + 1 = ?");
    }
}

