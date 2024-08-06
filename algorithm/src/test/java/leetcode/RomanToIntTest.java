package leetcode;

import org.junit.Test;

/**
 * @author lichuangjian
 * @date 2023/7/18
 */
public class RomanToIntTest {

    @Test
    public void test() {
        int mcmxciv = romanToInt("MCMXCIV");
        System.out.println(mcmxciv);
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == 'I') {
                if (i < length - 1) {
                    if (chars[i + 1] == 'V') {
                        i++;
                        result += 4;
                    } else if (chars[i + 1] == 'X') {
                        i++;
                        result += 9;
                    } else {
                        result += 1;
                    }
                } else {
                    result += 1;
                }
                continue;
            }
            if (chars[i] == 'V') {
                result += 5;
                continue;
            }
            if (chars[i] == 'X') {
                if (i < length - 1) {
                    if (chars[i + 1] == 'L') {
                        i++;
                        result += 40;
                    } else if (chars[i + 1] == 'C') {
                        i++;
                        result += 90;
                    } else {
                        result += 10;
                    }
                } else {
                    result += 10;
                }
                continue;
            }
            if (chars[i] == 'L') {
                result += 50;
                continue;
            }
            if (chars[i] == 'C') {
                if (i < length - 1) {
                    if (chars[i + 1] == 'D') {
                        i++;
                        result += 400;
                    } else if (chars[i + 1] == 'M') {
                        i++;
                        result += 900;
                    } else {
                        result += 100;
                    }
                } else {
                    result += 100;
                }
                continue;
            }
            if (chars[i] == 'D') {
                result += 500;
                continue;
            }
            if (chars[i] == 'M') {
                result += 1000;
            }
        }
        return result;
    }
}
