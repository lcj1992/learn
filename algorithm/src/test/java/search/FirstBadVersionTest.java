package search;

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
            int left = 1, right = n;
            while (left < right) { // 循环直至区间左右端点相同
                int mid = left + (right - left) / 2; // 防止计算时溢出
                if (isBadVersion(mid)) {
                    right = mid; // 答案在区间 [left, mid] 中
                } else {
                    left = mid + 1; // 答案在区间 [mid+1, right] 中
                }
            }
            // 此时有 left == right，区间缩为一个点，即为答案
            return left;
        }
    }

}
