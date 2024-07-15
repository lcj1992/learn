package ds.stack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/decode-string/">...</a>
 * 字符串解码
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class DecodeStringTest {

    @Test
    public void test() {
        String res = decodeString("a3[3[a]]2[bc]");
        System.out.println(res);
    }

    /**
     * <a href="https://leetcode.cn/problems/decode-string/solutions/19447/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/">...</a>
     * 思路：本题难点在于括号内嵌套括号，需要从内向外生成与拼接字符串
     */
    public String decodeString(String s) {
        char[] carr = s.toCharArray();
        // 两个栈，一个记录数字[]前的数字，一个记录[]中的字符
        Deque<Integer> multiDeque = new ArrayDeque<>();
        Deque<String> strDeque = new ArrayDeque<>();
        int multi = 0;
        StringBuilder res = new StringBuilder();
        for (char c : carr) {
            if (c >= '0' && c <= '9') {
                multi = multi * 10 + c - '0';
                continue;
            }
            if (c == '[') {
                multiDeque.addFirst(multi);
                strDeque.addFirst(res.toString());
                multi = 0;
                res = new StringBuilder();
                continue;
            }
            if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int curMulti = multiDeque.removeFirst();
                for (int i = 0; i < curMulti; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(strDeque.removeFirst() + tmp);
                continue;
            }
            res.append(c);
        }
        return res.toString();
    }


}
