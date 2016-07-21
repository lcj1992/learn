package dao;

import model.TestModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @Test
    public void saveTest() throws Exception {

        TestModel test  = new TestModel();
        test.setId(10);
        test.setName("fuck");
        testDao.saveTest(test);
    }

    @Test
    public void deleteTestById() throws Exception {

    }

    @Test
    public void loadTestById() throws Exception {

    }

}