package aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/5
 * Time: 下午3:06
 */
@ControllerAdvice
public class ExceptionControllerAdvice {


    @ExceptionHandler
    @ResponseBody
    public void handleException(){
        System.out.println("heheda");
    }
}
