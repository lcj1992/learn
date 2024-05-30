package linear.array;

import common.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        List<int[]> merge = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (merge.isEmpty() || merge.get(merge.size() - 1)[1] < left) {
                merge.add(new int[]{left, right});
            } else {
                merge.get(merge.size() - 1)[i] = Math.max(merge.get(merge.size() - 1)[1], right);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
