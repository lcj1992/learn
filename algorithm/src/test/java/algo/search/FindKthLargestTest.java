package algo.search;

import common.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/">...</a>
 *
 * @author foolchid
 * @date 2024/5/29
 **/
public class FindKthLargestTest {

    @Test
    public void test() {
        int res = findKthLargest(new int[]{3, 2, 4, 1, 5, 6, 4, 7}, 2);
        System.out.println(res);
        res = findKthLargest2(new int[]{3, 2, 4, 1, 5, 6, 4, 7}, 2);
        System.out.println(res);
        res = findKthLargest3(new int[]{3, 2, 4, 1, 5, 6, 4, 7}, 2);
        System.out.println(res);
    }


    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[k];
        }
        int x = nums[l];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < x);
            do {
                j--;
            } while (nums[j] > x);
            if (i < j) {
                swap(nums, i, j);
            }
        }
        if (k <= j) {
            return quickSelect(nums, l, j, k);
        }
        return quickSelect(nums, j + 1, r, k);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest2(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }

    private int quickSelect(List<Integer> nums, int k) {
        // 随机选择基准数
        Random rand = new Random();
        int pivot = nums.get(rand.nextInt(nums.size()));
        // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
        List<Integer> big = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot) {
                big.add(num);
                continue;
            }
            if (num < pivot) {
                small.add(num);
            }
        }
        // 第 k 大元素在 big 中，递归划分
        if (k <= big.size()) {
            return quickSelect(big, k);
        }
        // 第 k 大元素在 small 中，递归划分
        if (nums.size() - small.size() < k) {
            return quickSelect(small, k - nums.size() + small.size());
        }
        // 第 k 大元素在 equal 中，直接返回 pivot
        return pivot;
    }

    /**
     * 是一种方法，但是会超时
     */
    public int findKthLargest3(int[] nums, int k) {
        int n = nums.length;
        return quickSelect3(nums, 0, n - 1, n - k);
    }

    private int quickSelect3(int[] nums, int low, int high, int k) {
        int pi = partition(nums, low, high);
        if (pi == k) {
            return nums[pi];
        }
        if (pi < k) {
            return quickSelect3(nums, pi + 1, high, k);
        }
        return quickSelect3(nums, low, pi - 1, k);

    }

    private int partition(int[] nums, int low, int high) {
        int random = new Random().nextInt(high - low + 1) + low;
        Utils.swap(nums, random, high);
        int pivot = nums[high];  // 基准值
        int i = (low - 1);  // 索引i，指向比基准小的区域的最后一个元素
        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于基准
            if (nums[j] <= pivot) {
                i++;
                // 交换 arr[i] 和 arr[j]
                Utils.swap(nums, i, j);
            }
        }
        // 交换 arr[i+1] 和 arr[high]（或基准值）
        Utils.swap(nums, i + 1, high);
        return i + 1;
    }

}
