package hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/first-unique-character-in-a-string/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class FirstUniqCharTest {

    @Test
    public void test() {
        int res = firstUniqChar("leetcode");
        System.out.println(res);
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;

    }
}
