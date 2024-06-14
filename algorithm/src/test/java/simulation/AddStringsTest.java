package simulation;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/add-strings/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class AddStringsTest {

    @Test
    public void test() {
        String res = addStrings("456", "77");
        System.out.println(res);
    }

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }

}
