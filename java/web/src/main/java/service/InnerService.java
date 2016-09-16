package service;

import dao.TestDao;
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


    public void innerTest(int id,String name) throws Exception {
        testDao.updateNameById(id,"c");
    }
}
