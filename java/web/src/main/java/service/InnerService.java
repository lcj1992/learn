package service;

import dao.TestDao;
import model.TestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lichuangjian on 16/7/21.
 * desprition:
 */
@Service
public class InnerService {

    Logger logger = LoggerFactory.getLogger(InnerService.class);

    @Resource
    private TestDao testDao;


    @Transactional
    public void innerTest() throws Exception {

        TestModel testModel = new TestModel();
        testModel.setId(101);
        testModel.setName("n");
        testDao.saveTest(testModel);
        testModel = new TestModel();
        testModel.setId(102);
        testModel.setName("m");
        testDao.saveTest(testModel);
    }
}
