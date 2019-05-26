package sort;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/19
 * Time: 上午9:48
 */
public class BubbleSort {

    // 对相邻的元素进行两两比较，顺序相反则进行交换，
    // 这样，每一趟会将最小或最大的元素“浮”到顶端，最终达到完全有序

    // 时间复杂度O(n^2)
    // 空间复杂度O(1)
    public void bubbleSort(int items[]) {
        if (items.length <= 1) {
            return;
        }
        for (int i = 0; i < items.length; i++) {

            for (int j = 0; j < items.length - i - 1; j++) {
                if (items[j] > items[j + 1]) {
                    Utils.swap(items, j, j + 1);
                }
            }
        }
    }
}
