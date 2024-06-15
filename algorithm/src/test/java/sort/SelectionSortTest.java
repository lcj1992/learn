package sort;

import common.Utils;
import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/19
 * Time: 上午9:49
 */
public class SelectionSortTest {

    @Test
    public void testSelectionSort() {
        int[] items = new int[]{10, 8, 5, 12, 13, 4, 34, 4, 89};
        selectionSort(items);
        Utils.printArray(items);
    }

    // 每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，
    // 直到所有元素排完为止，简单选择排序是不稳定排序。
    public void selectionSort(int[] items) {
        if (items.length <= 1) {
            return;
        }
        for (int i = 0; i < items.length; i++) {
            for (int j = i + 1; j < items.length; j++) {
                if (items[j] < items[i]) {
                    Utils.swap(items, i, j);
                }
            }
        }
    }

}
