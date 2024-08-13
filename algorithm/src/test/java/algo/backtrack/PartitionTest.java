package algo.backtrack;

import common.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/">...</a>
 * 分割回文串
 */
public class PartitionTest {

    @Test
    public void test() {
        List<List<String>> res = partition("baa");
        Utils.print(res);
    }


    public List<List<String>> partition(String s) {
        // 记录回文串状态
        boolean[][] dp = dp(s);
        List<List<String>> ret = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        // 回溯，并利用回文串状态进行剪枝
        backtrack(ans, s, 0, dp, ret);
        return ret;
    }

    private boolean[][] dp(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        // 单个字符肯定是回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        // 检查两个字符
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }
        // 多个字符
        for (int len = 3; len <= length; len++) {
            for (int i = 0; i < length - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        return dp;
    }

    public void backtrack(List<String> ans, String s, int i, boolean[][] dp, List<List<String>> ret) {
        if (i == s.length()) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < s.length(); ++j) {
            if (dp[i][j]) {
                ans.add(s.substring(i, j + 1));
                backtrack(ans, s, j + 1, dp, ret);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
