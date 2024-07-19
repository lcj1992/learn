package ds.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/meeting-rooms/">...</a>
 * 会议室
 * 思路：数组、排序
 *
 * @author foolchid
 * @date 2024/5/23
 **/
public class CanAttendMeetingsTest {

    @Test
    public void test() {
        int[] arr1 = new int[]{0, 30};
        int[] arr2 = new int[]{60, 240};
        int[] arr3 = new int[]{90, 120};
        boolean res = canAttendMeetings(new int[][]{arr1, arr2, arr3});
        System.out.println(res);
    }

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
