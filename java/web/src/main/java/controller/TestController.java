package controller;

import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chuangjian.li
 * @date 16-1-9
 */
@Controller
@Builder
public class TestController {

    private int age;

    private String name;

    @RequestMapping("testException")
    public String exceptionTest() throws Exception {
        throw new Exception("test exception to error page");
    }

    @RequestMapping("login")
    public String loginTest() throws Exception {
        System.out.println("login success");
        return "success";
    }

    public static void main(String[] args) {
        TestController testController = TestController.builder().age(10).name("lcj").build();
    }
}
