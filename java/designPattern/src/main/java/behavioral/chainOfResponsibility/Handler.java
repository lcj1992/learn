package behavioral.chainOfResponsibility;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/7/8
 * Time: 下午8:35
 */
public abstract class Handler {

    protected Handler successor;

    public abstract void handleRequest();

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
