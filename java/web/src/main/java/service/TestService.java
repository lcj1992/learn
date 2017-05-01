package service;

import dao.TestDao;
import model.TestModel;
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

    @Resource
    private TestDao testDao;

    public int test(TestModel testModel) {
        return testDao.saveTest(testModel);
    }
}
