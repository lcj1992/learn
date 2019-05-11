package sort;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 上午8:00
 */
public class Sort {

    static void bubbleSort(int items[]) {
        if (items.length <= 1) {
            return;
        }
        for (int i = 0; i < items.length - 1; i++) {
            for (int j = 0; j < items.length - 1 - i; j++) {
                if (items[j] > items[j + 1]) {
                    swap(items, j, j + 1);
                }
            }
        }
    }

    static void insertionSort(int items[]) {

    }

    static void selectionSort(int items[]) {
        if (items.length <= 1) {
            return;
        }
        for (int i = 0; i < items.length - 1; i++) {
            boolean swapped = false;
            for (int j = i + 1; j < items.length; j++) {
                if (items[i] > items[j]) {
                    swap(items, i, j);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }

        }
    }

    private static void swap(int[] items, int i, int j) {
        int tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    public static void quickSort(int items[]) {

    }

    public static void shellSort(int items[]) {

    }

    public static void heapSort(int items[]) {

    }

}
