package webservice;

import javax.jws.WebService;

/**
 * Created by chuangjian.li
 * @Desc 定义:SEI service endpoint interface
 * 16/5/7
 */
@WebService
public interface IMyService {

    int add(int a, int b);

    int minus(int a, int b);
}
