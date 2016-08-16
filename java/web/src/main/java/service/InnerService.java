package service;

import dao.TestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lichuangjian on 16/7/21.
 * desprition:
 */
@Service
public class InnerService {

    Logger logger  = LoggerFactory.getLogger(InnerService.class);

    @Resource
    private TestDao testDao;


    public void innerTest() throws Exception {
        try {
            testDao.updateNameById(101,"n");
            testDao.updateNameById(100,"m");
        } catch (Exception e){
            logger.error("fuck",e);
        }
    }
}
