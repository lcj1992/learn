package sort;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;


/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 下午12:03
 */
public class SortTest {
    @Test
    public void testBubbleSort() throws Exception {
        int[] items = new int[]{10, 8, 5, 12, 13, 4, 34, 4, 89};
        Sort.bubbleSort(items);
        print(items);
    }

    @Test
    public void testSelectionSort() throws Exception {
        int[] items = new int[]{10, 8, 5, 12, 13, 4, 34, 4, 89};
        Sort.selectionSort(items);
        print(items);
    }

    @Test
    public void testInsertionSort() throws Exception {
        int[] items = new int[]{10, 8, 5, 12, 13, 4, 34, 4, 89};
        Sort.insertionSort(items);
        print(items);
    }

    private void print(int[] items) {
        List<Integer> list = Lists.newArrayList();
        for (int item : items) {
            list.add(item);
        }
        System.out.println(list);
    }
}
