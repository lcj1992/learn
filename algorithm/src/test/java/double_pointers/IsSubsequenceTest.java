package double_pointers;

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


    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
