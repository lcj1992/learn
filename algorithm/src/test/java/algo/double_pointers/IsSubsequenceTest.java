package algo.double_pointers;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/is-subsequence/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class IsSubsequenceTest {

    @Test
    public void test() {
        boolean subsequence = isSubsequence("abc", "aeebdc");
        System.out.println(subsequence);
    }

    /**
     * 1. 以s逐个遍历，匹配t中的字符
     * 2. 如果全部能匹配上，则是子串
     */
    public boolean isSubsequence(String s, String t) {
        // source 坐标
        int i = 0;
        int n = s.length();
        // target 坐标
        int j = 0;
        int m = t.length();

        while (i < n && j < m) {
            // 逐个比对s的字符
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // 遍历t的字符
            j++;
        }
        return i == n;
    }
}
