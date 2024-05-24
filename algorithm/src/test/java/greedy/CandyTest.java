package greedy;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/candy/description/">...</a>
 * 分发糖果
 *
 * @author foolchid
 * @date 2024/5/23
 **/
public class CandyTest {

    @Test
    public void test() {
        int[] ratings = {1, 0, 2};
        int result = candy(ratings);
        System.out.println(result);
    }

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < ratings.length; i++) {
            total += 1;
        }
        return total;
    }
}
