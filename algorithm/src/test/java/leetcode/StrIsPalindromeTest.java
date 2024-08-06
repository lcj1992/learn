package leetcode;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome/">验证回文串</a>
 *
 * @author lichuangjian
 * @date 2023/8/17
 */
public class StrIsPalindromeTest {

    @Test
    public void test() {
        boolean palindrome = isPalindrome(".G?j!:;;:Gj?!.");
        System.out.println(palindrome);
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char frontChar = chars[i];
            char endChar = chars[j];
            boolean continueFlag = false;
            if (!Character.isLetterOrDigit(frontChar)) {
                i++;
                continueFlag = true;
            }
            if (!Character.isLetterOrDigit(endChar)) {
                j--;
                continueFlag = true;
            }
            if (continueFlag) {
                continue;
            }
            if (frontChar != endChar) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
