package test.aop;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/6/18
 * Time: 上午9:11
 */
public interface TicketService {

    // 售票
    void sellTicket();

    // 询价
    void inquire();

    // 退票
    void withdraw();
}
