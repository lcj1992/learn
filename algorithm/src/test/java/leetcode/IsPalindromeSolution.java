package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author lichuangjian
 * @date 2023/7/14
 */
public class IsPalindromeSolution {

    public static void main(String[] args) {
        IsPalindromeSolution solution = new IsPalindromeSolution();
        boolean palindrome = solution.isPalindrome(10);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> nums = new ArrayList<>();
        while (x > 0) {
            nums.add(x % 10);
            x = x / 10;
        }
        int numSize = nums.size() / 2;
        for (int i = 0; i < numSize; i++) {
            if (!Objects.equals(nums.get(i), nums.get(nums.size() - i - 1))) {
                return false;
            }
        }
        return true;


    }
}
