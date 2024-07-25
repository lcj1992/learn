package algo.sort;

import common.Utils;
import org.junit.Test;

import java.util.Random;

/**
 * Desc: 快排
 *
 * @author foolchild
 * @date 2019/5/19
 */
public class QuickSortTest {

    @Test
    public void test() {
        int[] nums = {4, 5, 2, 3, 8, 20, 10, 12};
        quickSort(nums, 0, nums.length - 1);
        Utils.print(nums);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            // 找到分区的索引
            int pi = partition(nums, low, high);
            // 分别对基准值前后的序列进行排序
            quickSort(nums, low, pi - 1);
            quickSort(nums, pi + 1, high);
        }
    }


    // 选择基准值，这里选择数组最后一个元素作为基准
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
