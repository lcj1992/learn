package algo.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/gray-code/">...</a>
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class GrayCodeTest {

    @Test
    public void test() {
        List<Integer> res = grayCode(3);
        System.out.println(res);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }
}
