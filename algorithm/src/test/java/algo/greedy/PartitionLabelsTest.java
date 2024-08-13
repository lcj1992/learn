package algo.greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/partition-labels/">...</a>
 * today1
 */
public class PartitionLabelsTest {

    @Test
    public void test() {
        List<Integer> res = partitionLabels("eccbbbbdec");
        System.out.println(res);
    }

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int l = 0;
        int r = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            r = Math.max(r, last[c - 'a']);
            if (i == r) {
                res.add(r - l + 1);
                l = r + 1;
            }
        }
        return res;
    }
}
