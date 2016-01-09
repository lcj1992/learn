package callback.syn;

import learn.java.callback.CallBack;

/**
 * Created by lcj on 15-5-9.
 *
 */
public class Sun implements CallBack {

    // 持有小赵引用
    private Zhao zhao;

    public Sun(Zhao zhao) {
        this.zhao = zhao;
    }

    public void askQuestion(final String question) {
        System.out.println("同步：\n小孙在考试，碰到一道题不会。小孙差不多就做了60分的题，能不能及格是个问题，以上厕所为由去厕所打电话询问小赵--->" + question);
        // 不新起线程就是同步
        zhao.executeMessage(Sun.this, question);
        play();
    }

    public void play() {
        System.out.println("只有小赵告诉小孙答案了，小孙才可以挂电话");
    }

    @Override
    public void solve(String result) {
        System.out.println(result);
    }

}
