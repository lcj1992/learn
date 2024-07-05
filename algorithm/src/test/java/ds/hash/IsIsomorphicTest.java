package ds.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/isomorphic-strings/">...</a>
 *
 * @author lichuangjian
 * @date 2023/8/25
 */
public class IsIsomorphicTest {

    public static void main(String[] args) {
        IsIsomorphicTest solution = new IsIsomorphicTest();
        boolean isomorphic = solution.isIsomorphic("badc", "baba");
        System.out.println(isomorphic);
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> s2tMap = new HashMap<>();
        Map<Character, Character> t2sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!s2tMap.containsKey(sc)) {
                s2tMap.put(sc, tc);
            }
            if (!t2sMap.containsKey(tc)) {
                t2sMap.put(tc, sc);
            }
            if (!s2tMap.get(sc).equals(tc) || !t2sMap.get(tc).equals(sc)) {
                return false;
            }
        }
        return true;
    }
}
