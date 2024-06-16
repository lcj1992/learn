package greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/candy/">...</a>
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
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = len - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                right[i - 1] = right[i] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }
}
