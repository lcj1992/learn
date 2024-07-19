package algo.double_pointers;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class ReverseWordsTest {

    @Test
    public void test() {
        String res = reverseWords("the sky is blue");
        System.out.println(res);

        StringBuilder sb = new StringBuilder();
        StringBuilder hello = sb.append("hello", 0, 5);
        System.out.println(hello);
    }

    /**
     * 调整i和j指针的
     */
    public String reverseWords(String s) {
        // 删除首尾空格
        s = s.trim();
        int right = s.length() - 1;
        int left = right;
        StringBuilder res = new StringBuilder();
        while (left >= 0) {
            // 找到首个空格, 即为单词的起始坐标-1
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            // 添加单词
            res.append(s, left + 1, right + 1).append(" ");
            // 跳过单词间空格,找到首个非空格，即为下个单词的末尾坐标
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            // right 指向下个单词的尾字符
            right = left;
        }
        // 转化为字符串并返回
        return res.toString().trim();
    }

    public String reverseWords2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
