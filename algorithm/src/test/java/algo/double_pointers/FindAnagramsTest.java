package algo.double_pointers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string">...</a>
 * 找到字符串中所有字母异位词
 * today
 */
public class FindAnagramsTest {

    @Test
    public void test() {
        String s = "tibcacbdata";
        List<Integer> indexes = findAnagrams(s, "abcd");
        System.out.println(indexes);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        for (int i = 1; i < sLen - pLen + 1; i++) {
            sCount[s.charAt(i - 1) - 'a']--;
            sCount[s.charAt(i + pLen - 1) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i);
            }
        }
        return ans;
    }

}
