package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chuangjian.li
 * @date 16-1-9
 */
@Controller
public class TestController {

    @RequestMapping("test")
    public String exceptionTest() throws Exception {
        throw new Exception("test exception to error page");
    }
}
