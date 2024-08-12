package algo.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/">...</a>
 * today
 */
public class LetterCombinationsTest {

    @Test
    public void test() {
        List<String> res = letterCombinations("23");
        System.out.println(res);
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        StringBuilder state = new StringBuilder();
        List<String> res = new ArrayList<>();
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(state, digits, 0, phoneMap, res);
        return res;
    }

    private void backtrack(StringBuilder state, String digits, int idx, Map<Character, String> phoneMap, List<String> res) {
        if (state.length() == digits.length()) {
            res.add(state.toString());
            return;
        }
        char num = digits.charAt(idx);
        String s = phoneMap.get(num);
        for (int i = 0; i < s.length(); i++) {
            state.append(s.charAt(i));
            backtrack(state, digits, idx + 1, phoneMap, res);
            state.deleteCharAt(state.length() - 1);
        }
    }
}
