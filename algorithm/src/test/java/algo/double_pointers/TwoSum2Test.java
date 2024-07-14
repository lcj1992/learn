package algo.double_pointers;

import common.Utils;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class TwoSum2Test {

    @Test
    public void test() {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        Utils.printArray(ints);
        ints = twoSum2(new int[]{2, 7, 11, 15}, 9);
        Utils.printArray(ints);
    }

    /**
     * 二分查找
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 双指针
     */
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

}
