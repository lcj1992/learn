package test;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/4/15
 * Time: 下午5:23
 */
@Component
public class Test {

    private String name = "lcj";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init() {
        name = "lichuangjian";
    }
}
