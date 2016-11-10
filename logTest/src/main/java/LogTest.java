import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2016/10/26
 * Time: 下午6:58
 */
public class LogTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        LOGGER.info("hello log");
        System.out.println(LOGGER.getClass());
    }
}
