package sort;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 下午12:03
 */
public class SortTest {

    private static final String RESULT = "44581012133489";

    @Test
    public void testBubbleSort() throws Exception {
        int[] items = new int[]{10, 8, 5, 12, 13, 4, 34, 4, 89};
        BubbleSort sort = new BubbleSort();
        sort.bubbleSort(items);
        Assert.assertEquals(print(items), RESULT);
    }

    @Test
    public void testSelectionSort() throws Exception {
        int[] items = new int[]{10, 8, 5, 12, 13, 4, 34, 4, 89};
        SelectionSort sort = new SelectionSort();
        sort.selectionSort(items);
        Assert.assertEquals(print(items), RESULT);
    }

    @Test
    public void testInsertionSort() throws Exception {
        int[] items = new int[]{10, 8, 5, 12, 13, 4, 34, 4, 89};
        InsertionSort sort = new InsertionSort();
        sort.insertionSort(items);
        Assert.assertEquals(print(items), RESULT);
    }

    @Test
    public void testQuickSort() throws Exception {
        int[] items = new int[]{10, 8, 5, 12, 13, 4, 34, 4, 89};
        QuickSort sort = new QuickSort();
        sort.quickSort(items);
        Assert.assertEquals(print(items), RESULT);
    }

    @Test
    public void testShellSort() throws Exception {
        int[] items = new int[]{10, 8, 5, 12, 13, 4, 34, 4, 89};
        ShellSort sort = new ShellSort();
        sort.shellSort(items);
        Assert.assertEquals(print(items), RESULT);
    }

    @Test
    public void testHeapSort() throws Exception {
        int[] items = new int[]{10, 8, 5, 12, 13, 4, 34, 4, 89};
        HeapSort sort = new HeapSort();
        sort.heapSort(items);
        Assert.assertEquals(print(items), RESULT);
    }

    private String print(int[] items) {
        List<Integer> list = Lists.newArrayList();
        for (int item : items) {
            list.add(item);
        }
        return list.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
