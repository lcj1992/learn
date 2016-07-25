package dao;

import model.TestModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import service.OuterService;

import javax.annotation.Resource;

/**
 * Created by lichuangjian on 16/7/21.
 * desprition:
 */
@ContextConfiguration(locations = {"classpath:config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDaoTest {

    @Resource
    private TestDao testDao;

    @Resource
    private OuterService outerService;

    @Before
    public void setUp(){
        testDao.deleteTestById(100);
        testDao.deleteTestById(101);
        testDao.deleteTestById(102);
        testDao.deleteTestById(103);
    }

    @Test
    @Transactional
    public void saveTest() throws Exception {
        TestModel test  = new TestModel();
        test.setId(12);
        test.setName("fuck");
        testDao.saveTest(test);
        throw new RuntimeException("test transaction");
    }

    @Test
    public void propagationTest() throws Exception {
        // inner正常 outer正常
        //
        outerService.outerTest();
    }
}