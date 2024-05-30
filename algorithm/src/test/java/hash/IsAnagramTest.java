package hash;

import org.junit.Test;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/valid-anagram/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class IsAnagramTest {

    @Test
    public void test() {
        boolean res = isAnagram("anagram", "nagaram");
        System.out.println(res);
    }

    public boolean isAnagram(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (len1 != len2) return false;
        HashMap<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            dic.put(s.charAt(i), dic.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < len2; i++) {
            dic.put(t.charAt(i), dic.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (int val : dic.values()) {
            if (val != 0) return false;
        }
        return true;
    }

}
