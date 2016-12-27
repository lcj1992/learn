package test;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2016/11/13
 * Time: 下午12:21
 */
@Service
public class TestService {

    @Resource
    private TestDao testDao;


    public TestDao getTestDao() {
        return testDao;
    }

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    public void print() {
        System.out.println(testDao.getTestModel());
    }

}
