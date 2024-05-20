package leetcode;

import org.junit.Test;

import java.util.*;

public class LengthOfLongestSubstringKDistinctSolution {
    @Test
    public void test() {
        String s = "eceba";
        int result = lengthOfLongestSubstringKDistinct(s, 2);
        System.out.println(result);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int left = 0;
        LinkedHashMap<Character, Integer> exists = new LinkedHashMap<>();
        int max = 0;
        for (int current = 0; current < arr.length; current++) {
            Character c = arr[current];
            exists.remove(c);
            exists.put(c, current);
            if (exists.size() > k) {
                // 调整left指针位置
                Map.Entry<Character, Integer> leftmost = exists.entrySet().iterator().next();
                exists.remove(leftmost.getKey());
                left = leftmost.getValue() + 1;
            }
            max = Math.max(max, current - left + 1);
        }
        return max;
    }

}

