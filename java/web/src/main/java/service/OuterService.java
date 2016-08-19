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
public class OuterService {

    @Resource
    private TestDao testDao;

    @Resource
    private InnerService innerService;

    @Transactional
    public void outerTest() throws Exception {
        TestModel test = new TestModel();
        test.setId(103);
        test.setName("c");
        testDao.saveTest(test);
        innerService.innerTest();
    }
}
