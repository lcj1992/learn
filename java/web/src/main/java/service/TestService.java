package service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2016/12/1
 * Time: 上午9:49
 */
@Service
public class TestService {

    private String name = "lcj";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
