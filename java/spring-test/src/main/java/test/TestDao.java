package test;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2016/11/13
 * Time: 下午12:23
 */
@Repository
public class TestDao {

    @Resource
    private TestModel testModel;

    public void setTestModel(TestModel testModel) {
        this.testModel = testModel;
    }

    public TestModel getTestModel() {
        return testModel;
    }
}
