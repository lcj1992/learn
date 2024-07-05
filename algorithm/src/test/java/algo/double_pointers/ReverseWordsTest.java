package algo.double_pointers;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class ReverseWordsTest {

    @Test
    public void test() {
        String res = reverseWords("the sky is blue");
        System.out.println(res);
    }

    /**
     * 调整i和j指针的
     */
    public String reverseWords(String s) {
        // 删除首尾空格
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            // 搜索首个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 添加单词
            res.append(s, i + 1, j + 1).append(" ");
            // 跳过单词间空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return res.toString().trim();
    }

}
