package callback;

/**
 * Created by lcj on 15-5-9. http://blog.csdn.net/xiaanming/article/details/8703708
 */

import learn.java.callback.asyn.Li;
import learn.java.callback.asyn.Wang;
import learn.java.callback.syn.Sun;
import learn.java.callback.syn.Zhao;


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

