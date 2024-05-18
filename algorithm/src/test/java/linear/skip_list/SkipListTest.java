package linear.skip_list;

import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/18
 * Time: 下午8:48
 */
public class SkipListTest {

    @Test
    public void test() {
        SkipList s = new SkipList();
        s.put("ABC", 1);
        s.put("DEF", 2);
        s.put("KLM", 3);
        s.put("HIJ", 4);
        s.put("GHJ", 5);
        s.put("AAA", 6);

        s.remove("ABC");
        s.remove("DEF");
        s.remove("KLM");
        s.remove("HIJ");
        s.remove("GHJ");
        s.remove("AAA");

        s.put("ABC", 7);
        s.put("DEF", 8);
        s.put("KLM", 9);
        s.put("HIJ", 10);
        s.put("GHJ", 11);
        s.put("AAA", 12);
    }
}
