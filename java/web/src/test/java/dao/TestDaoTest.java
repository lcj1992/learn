package dao;

import model.TestModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import service.OuterService;
import service.TestService;

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
    @Resource
    private TestService testService;

    @Test
    @Transactional
    public void saveTest() throws Exception {
        int id = 1;
        System.out.println(testDao.saveTest(createTestModel(id)));
        System.out.println(testService.test(createTestModel(++id)));
        System.out.println(testService.test(createTestModel(++id)));
        System.out.println(testService.test(createTestModel(++id)));
        System.out.println(testService.test(createTestModel(++id)));
        System.out.println(testService.test(createTestModel(++id)));
        System.out.println(testDao.loadTestById(2));
    }

    private TestModel createTestModel(int id) {
        TestModel test = new TestModel();
        test.setId(id);
        test.setName("lcj");
        return test;
    }

    @Test
    public void propagationTest() throws Exception {
        outerService.outerTest0();
    }

}