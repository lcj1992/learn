
package dao;

import model.TestModel;
import model.TestNameModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.OuterService;

import javax.annotation.Resource;
import java.util.Date;

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

    @Test
    public void saveTest() throws Exception {
        TestModel test = new TestModel();
        test.setPackageId(1000000);
        testDao.saveTest(test);
    }

    @Test
    public void propagationTest() throws Exception {
        outerService.outTest();
    }

}