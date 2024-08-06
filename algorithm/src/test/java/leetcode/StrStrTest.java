package leetcode;

import org.junit.Test;

/**
 * @author lichuangjian
 * @date 2023/8/8
 */
public class StrStrTest {

    @Test
    public void test() {
        int i = strStr("sadbutsad", "sad");
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        for (int i = 0; i < haystack.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (i + j >= haystackArray.length) {
                    break;
                }
                if (haystackArray[i + j] != needleArray[j]) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
