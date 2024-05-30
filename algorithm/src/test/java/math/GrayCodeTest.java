package math;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/gray-code/
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class GrayCodeTest {

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
