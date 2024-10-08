package algo.search;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/first-bad-version/">...</a>
 * 第一个错误的版本
 *
 * @author foolchid
 * @date 2024/5/29
 **/
public class FirstBadVersionTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        int res = solution.firstBadVersion(5);
        System.out.println(res);
    }

    public static abstract class VersionControl {
        boolean isBadVersion(int version) {
            if (version >= 4) {
                return true;
            }
            return false;
        }
    }

    public static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;
            int res = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                boolean bad = isBadVersion(mid);
                if (bad) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return res;
        }
    }

}
