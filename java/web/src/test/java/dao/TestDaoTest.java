package dao;

import model.TestModel;
import org.apache.ibatis.javassist.runtime.Inner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestParam;
import service.InnerService;
import service.OuterService;

import javax.annotation.Resource;
import java.lang.reflect.Field;

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
    private InnerService innerService;

    @Before
    public void setUp(){
//        testDao.deleteTestById(101);
//        testDao.deleteTestById(102);
//        testDao.deleteTestById(103);
    }

    @Test
    @Transactional
    public void saveTest() throws Exception {
        TestModel test  = new TestModel();
        test.setId(2);
        test.setName("lcj");
        testDao.saveTest(test);
//        throw new RuntimeException("test transaction");
    }

    @Test
    public void propagationTest() throws Exception {
        outerService.outerTest();
    }

    @Test
    public void test() throws Exception {
        innerService.innerTest(100,"lcj");
    }
}