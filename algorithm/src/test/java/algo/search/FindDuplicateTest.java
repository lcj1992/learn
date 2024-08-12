package algo.search;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/find-the-duplicate-number/">...</a>
 * 寻找重复数
 *
 * @author foolchid
 * @date 2024/5/29
 * today
 **/
public class FindDuplicateTest {
    @Test
    public void test() {
        int res = findDuplicate(new int[]{1, 3, 4, 2, 2});
        System.out.println(res);
    }

    /**
     *
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }


    /**
     * 快慢指针
     */
    public int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
