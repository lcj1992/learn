package webservice;

import javax.jws.WebService;

/**
 * Created by chuangjian.li
 * 16/5/7
 */
@WebService(endpointInterface = "webservice.IMyService")
public class MyService implements IMyService {
    public int add(int a, int b) {
        System.out.println("a+b=" + (a + b));
        return a + b;
    }

    public int minus(int a, int b) {
        System.out.println("a-b=" + (a - b));
        return a - b;
    }
}
