package algo.search;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/">...</a>
 */
public class FindMedianSortedArraysTest {

    @Test
    public void test() {
        double res = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 对长度较小的进行二分查找
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int totalLeft = (m + n + 1) / 2;

        // 在nums1的区间[0, m]里查找恰当的分割线
        // 使得nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]
        int left = 0;
        int right = m;
        while (left < right) {
            // [1,2,3] -> [1,2] [3]
            // [1,2,3,4] -> [1,2] [3,4]
            int i = left + (right - left + 1) / 2;
            int j = (m + n + 1) / 2 - i;
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索区间[left, i - 1]
                right = i - 1;
            } else {
                // 下一轮搜索区间[i, right]
                left = i;
            }
        }
        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
        int nums1RightMin = (i == m ? Integer.MAX_VALUE : nums1[i]);
        int nums2LeftMax = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
        int nums2RightMin = (j == n ? Integer.MAX_VALUE : nums2[j]);
        int median1 = Math.max(nums1LeftMax, nums2LeftMax);
        int median2 = Math.min(nums1RightMin, nums2RightMin);
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }

}
