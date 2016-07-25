package service;

import dao.TestDao;
import model.TestModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lichuangjian on 16/7/21.
 * desprition:
 */
@Service
public class InnerService {

    @Resource
    private TestDao testDao;

    @Transactional(rollbackFor = Exception.class)
    public void innerTest() throws Exception {
        TestModel testModel = new TestModel();
        testModel.setId(100);
        testModel.setName("a");
        testDao.saveTest(testModel);
        TestModel testModel1 = new TestModel();
        testModel1.setId(101);
        testModel1.setName("b");
        testDao.saveTest(testModel1);
        throw new Exception("inner exception");
    }
}
