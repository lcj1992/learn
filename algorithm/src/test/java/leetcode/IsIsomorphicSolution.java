package leetcode;

import java.util.*;

/**
 * @author lichuangjian
 * @date 2023/8/25
 */
public class IsIsomorphicSolution {

    public static void main(String[] args) {
        IsIsomorphicSolution solution = new IsIsomorphicSolution();
        boolean isomorphic = solution.isIsomorphic("badc", "baba");
        System.out.println(isomorphic);
    }

    public boolean isIsomorphic(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if (sChars.length != tChars.length) {
            return false;
        }
        int length = sChars.length;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> targetSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(sChars[i])) {
                map.put(sChars[i], tChars[i]);
                if (targetSet.contains(tChars[i])) {
                    return false;
                }
                targetSet.add(tChars[i]);
                continue;
            }
            if (!Objects.equals(map.get(sChars[i]), tChars[i])) {
                return false;
            }
        }
        return true;
    }
}
