package service;

import dao.TestDao;
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

    public void outerTest() throws Exception {
        outerTest0();
    }

    @Transactional
    public void outerTest0(){
        testDao.updateNameById(101,"why");
        throw new RuntimeException();
//        testDao.updateNameById(102,"b");
    }
}
