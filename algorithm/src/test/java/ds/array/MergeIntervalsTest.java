package ds.array;

import common.Utils;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/SsGoHC/">...</a>
 * 合并区间
 * 思路：数组排序
 *
 * @author foolchid
 * @date 2024/5/23
 **/
public class MergeIntervalsTest {

    @Test
    public void test() {
        int[] arr1 = new int[]{1, 3};
        int[] arr2 = new int[]{2, 6};
        int[] arr3 = new int[]{8, 10};
        int[] arr4 = new int[]{15, 18};
        int[][] intervals = new int[][]{arr1, arr2, arr3, arr4};
        int[][] merge = merge(intervals);
        Arrays.stream(merge).forEach(Utils::printArray);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Deque<int[]> res = new LinkedList<>();
        res.addLast(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // 细分为三种情况
            // [1,2][2,3] -> [1,3]
            // [1,3][2,4] -> [1,4]
            // [1,4][2,3] -> [1,4]
            if (res.getLast()[1] >= intervals[i][0]) {
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            } else {
                res.addLast(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
