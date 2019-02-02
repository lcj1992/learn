package model;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/8/9
 * Time: 下午12:28
 */
public class TestNameModel {
    private String fuckName;

    private TestNameModel() {}

    public TestNameModel(String fuckName) {
        this.fuckName = fuckName;
    }

    @Override
    public String toString() {
        return "TestNameModel{" +
                "fuckName='" + fuckName + '\'' +
                '}';
    }
}

