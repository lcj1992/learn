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

    @Transactional
    public void outerTest() throws Exception {
        testDao.updateNameById(101,"a");
        innerService.innerTest();
    }
}
