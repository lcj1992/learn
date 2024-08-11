package ds.hash;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/first-missing-positive/">缺失的第一个正数</a>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class FirstMissingPositiveTest {

    @Test
    public void test() {
        int res = firstMissingPositive(new int[]{3, -1, 1, 4});
        System.out.println(res);
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 对于一个长度为 N 的数组，没有出现的最小正整数只能在 [1, N+1] 中
        // 第一次打标，处理值小于等于0的元素，修改其值为n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // 再次打标，处理值在[1,n]之间的元素，将元素的绝对值小于等于n的，修改其值为绝对值相反数
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        // 第一个正数的下标+1则对应的就是结果
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
