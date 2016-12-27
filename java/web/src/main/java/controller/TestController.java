package controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.CommonService;
import service.SpringService;
import service.TestService;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author chuangjian.li
 * @date 16-1-9
 */
@RestController
@Lazy(value = false)
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("testException")
    public String exceptionTest() throws Exception {
        throw new Exception("test exception to error page");
    }

    @RequestMapping("login")
    public String loginTest() throws Exception {
        System.out.println("login success");
        return "success";
    }

    @RequestMapping("test")
    public String test(@RequestParam Set<Long> orderIds) {
        System.out.println(testService.getName());
        System.out.println(SpringService.getBean("commonService", CommonService.class));
        return "hello";

    }

}
