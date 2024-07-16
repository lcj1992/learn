package ds.array;

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
        int res = findKthLargest(new int[]{3, 2, 4, 1, 5, 6, 4}, 2);
        System.out.println(res);
        res = findKthLargest2(new int[]{3, 2, 4, 1, 5, 6, 4}, 2);
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


    private int quickSelect(List<Integer> nums, int k) {
        // 随机选择基准数
        Random rand = new Random();
        int pivot = nums.get(rand.nextInt(nums.size()));
        // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot) big.add(num);
            else if (num < pivot) small.add(num);
            else equal.add(num);
        }
        // 第 k 大元素在 big 中，递归划分
        if (k <= big.size()) return quickSelect(big, k);
        // 第 k 大元素在 small 中，递归划分
        if (nums.size() - small.size() < k) return quickSelect(small, k - nums.size() + small.size());
        // 第 k 大元素在 equal 中，直接返回 pivot
        return pivot;
    }

    public int findKthLargest2(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }

}
