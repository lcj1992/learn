package callback.asyn;

import learn.java.callback.CallBack;
import learn.java.callback.ThreadUtil;

/**
 * Created by lcj on 15-5-9.
 *
 */
public class Wang implements CallBack {

    // 持有小李引用
    private Li li;

    public Wang(Li li) {
        this.li = li;
    }

    public void askQuestion(final String question) {
        System.out.println("异步:\n寒假期间小王做作业，碰到一道题不会，发短信问小李--->" + question);
        // 这里新起线程就是异步，
        new Thread(new Runnable() {
            @Override
            public void run() {
                li.executeMessage(Wang.this, question);
            }
        }).start();
        //Thread.sleep 5s 模拟小王等待过程;
        ThreadUtil.sleep(10000L);
        play();
    }

    public void play() {
        System.out.println("小王等啊等，实在等不及了就去逛街了(不需要小李应答，在小李未回答时也可以干其他事)");
    }

    @Override
    public void solve(String result) {
        System.out.println(result);
    }

}
