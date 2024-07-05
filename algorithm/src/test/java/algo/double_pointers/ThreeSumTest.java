package algo.double_pointers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/3sum/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class ThreeSumTest {

    @Test
    public void test() {
        List<List<Integer>> res = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        res.forEach(System.out::println);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums); // 排序
        for (int k = 0; k < len; k++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[k] > 0) {
                break;
            }
            // 去重
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1;
            int j = len - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    // 去重
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    // 去重
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (sum < 0) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return ans;
    }

}
