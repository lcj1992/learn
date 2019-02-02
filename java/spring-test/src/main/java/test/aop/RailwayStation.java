package test.aop;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/6/18
 * Time: 上午9:12
 */
public class RailwayStation implements TicketService {
    @Override
    public void sellTicket() {
        System.out.println("卖票。。。。。。。。。。。。。。。");
        throw new RuntimeException("不卖了");
    }

    @Override
    public void inquire() {
        System.out.println("问询。。。。。。。。。。。。。。。");
    }

    @Override
    public void withdraw() {
        System.out.println("退票。。。。。。。。。。。。。。。。");
    }
}
