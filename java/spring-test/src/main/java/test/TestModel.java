package test;

import org.springframework.stereotype.Component;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2016/11/13
 * Time: 下午12:25
 */
@Component
public class TestModel {
    private String name="123";
    private int age=20;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestDao{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
