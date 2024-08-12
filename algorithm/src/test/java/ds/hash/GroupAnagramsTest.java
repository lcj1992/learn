package ds.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams/">...</a>
 */
public class GroupAnagramsTest {

    @Test
    public void test() {
        List<List<String>> res = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(res);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // 题目中说了仅包含小写字母
            int[] counts = new int[26];
            String s = strs[i];
            int len = s.length();
            for (int j = 0; j < len; j++) {
                counts[s.charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < 26; k++) {
                if (counts[k] != 0) {
                    sb.append((char) ('a' + k)).append(counts[k]);
                }
            }
            String key = sb.toString();
            List<String> list = resMap.getOrDefault(key, new ArrayList<>());
            list.add(s);
            resMap.put(key, list);
        }
        return new ArrayList<>(resMap.values());
    }
}
