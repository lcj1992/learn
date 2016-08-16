package dao;

import model.TestModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by lichuangjian on 16/7/21.
 * desprition:
 */
@Repository
public interface TestDao {

    int saveTest(TestModel testModel);

    int deleteTestById(@Param("id") int id);

    int updateNameById(@Param("id") int id, @Param("name") String name);

    int loadTestById(@Param("id") int id);
}

