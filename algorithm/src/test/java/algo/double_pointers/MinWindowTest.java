package algo.double_pointers;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/minimum-window-substring/">最小覆盖子串</a>
 */
public class MinWindowTest {

    @Test
    public void test() {
        String res = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(res);
    }

    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() < t.length()) {
            return "";
        }
        // 维护两个数组，记录已有字符串指定字符的出现次数，和目标字符串指定字符的出现次数
        // ASCII表总长128
        int[] target = new int[128];
        int[] source = new int[128];
        //记录目标字符串指定字符的出现次数
        for (int i = 0; i < t.length(); i++) {
            target[t.charAt(i)]++;
        }
        // 左、右指针
        int left = 0;
        int right = 0;
        // 最小长度（初始值设置为不可达到的长度）
        int minLen = s.length() + 1;
        // 已有字符串中 目标字符串指定字符的出现总频次，count是本解法的精髓
        int count = 0;
        // 最小覆盖子串再原字符串中的起始位置
        int start = 0;
        while (right < s.length()) {
            char rc = s.charAt(right);
            // 目标字符串不包含该字符，直接跳过
            if (target[rc] == 0) {
                right++;
                continue;
            }
            // 当且仅当已有字符串目标字符出现的次数小于目标字符串字符的出现次数时，count才会+1
            // 为了后续能直接判断已有字符串是否已经包含了目标字符串的所有字符，不需要挨个比对字符出现的次数
            if (source[rc] < target[rc]) {
                count++;
            }
            // 已有字符串中目标字符出现的次数+1
            source[rc]++;
            // 移动右指针
            right++;
            // 当count==t.length，则出现覆盖子串
            while (count == t.length()) {
                // 当窗口的长度比已有的最短值小时，更改最小值，并记录起始位置
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                // 取左指针的值
                char lc = s.charAt(left);
                // 目标字符串不包含该字符，移动左指针，并跳过
                if (target[lc] == 0) {
                    left++;
                    continue;
                }
                // 如果该字符被目标字符串需要，且出现的频次正好等于指定频次，那么如果去掉了这个字符，就不满足覆盖子串的条件
                // 破坏循环条件跳出循环
                if (target[lc] == source[lc]) {
                    count--;
                }
                // 已有字符串中目标字符出现的次数-1
                source[lc]--;
                // 移动左指针
                left++;
            }
        }
        if (minLen == s.length() + 1) {
            return "";
        }
        return s.substring(start, start + minLen);
    }
}

