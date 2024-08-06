package leetcode;

import org.junit.Test;

/**
 * @author lichuangjian
 * @date 2023/8/9
 */
public class MergeTest {

    @Test
    public void test() {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {0};
        int n = 0;
        merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0; j < n; j++) {
            insertOne(nums1, m + j, nums2[j]);
        }
    }

    private void insertOne(int[] nums1, int numsLength, int val) {
        int index = numsLength;
        // 找到坐标
        for (int i = 0; i < numsLength; i++) {
            if (val < nums1[i]) {
                index = i;
                break;
            }
        }
        // 调整数组顺序
        for (int i = numsLength; i > index; i--) {
            nums1[i] = nums1[i - 1];
        }
        // 插入当前值
        nums1[index] = val;
    }

}
