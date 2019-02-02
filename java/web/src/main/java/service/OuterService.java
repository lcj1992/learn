package service;

import aop.log.Lifecycle;
import aop.log.Result;
import dao.TestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by lichuangjian on 16/7/21.
 * desprition:
 */
@Service
public class OuterService {

    @Resource
    private TestDao testDao;

    @Lifecycle
    public Result outTest(){
        return new Result();
    }

    public void outerTest0() {
        Date outThreadTime = new Date();
        final String outThread = "outThread : ";
        testDao.updateNameById(1, outThread + outThreadTime);
    }
}
