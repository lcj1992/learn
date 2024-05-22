package common;

/**
 * @author foolchid
 * @date 2024/5/22
 **/
public class Utils {
    public static void printArray(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return;
        }
        for (int anInt : arrays) {
            System.out.print(anInt + " ");
        }
        System.out.println();
    }
}
