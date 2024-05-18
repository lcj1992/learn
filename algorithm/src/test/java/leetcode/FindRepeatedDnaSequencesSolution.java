package leetcode;

import java.util.*;

/**
 * @author lichuangjian
 * @date 2023/7/9
 */
public class FindRepeatedDnaSequencesSolution {

    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        FindRepeatedDnaSequencesSolution solution = new FindRepeatedDnaSequencesSolution();
        List<String> repeatedDnaSequences = solution.findRepeatedDnaSequences(s);
        System.out.println(repeatedDnaSequences);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        char[] chars = s.toCharArray();
        Set<String> results = new HashSet<>();
        Map<String, Boolean> windowsMap = new HashMap<>();
        for (int i = 0; i < chars.length - 10 + 1; i++) {
            String temp = s.substring(i, i + 10);
            if (windowsMap.containsKey(temp)) {
                results.add(temp);
            } else {
                windowsMap.put(temp, true);
            }
        }
        return new ArrayList<>(results);
    }
}
