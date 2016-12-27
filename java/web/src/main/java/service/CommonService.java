package service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2016/12/14
 * Time: 上午10:58
 */
@Component
public class CommonService {

    public void printHello() {
        System.out.println("hello");
    }

    @Transactional
    public void testTransaction() {
        System.out.println("呵呵哒");
    }
}
