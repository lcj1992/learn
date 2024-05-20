package leetcode;

import org.junit.Test;

public class ContainCharArrayTest {

    @Test
    public void test() {
        String s = "tibcacbdata";
        char[] array = new char[]{'a', 'b', 'c', 'd'};
        int index = findIndex(s, array);
        System.out.println(index);
    }

    private int findIndex(String s, char[] ch) {

        int targetCharSize = ch.length;
        int totalCharSize = s.length();

        if (targetCharSize > totalCharSize) {
            return -1;
        }

        for (int i = 0; i < totalCharSize - targetCharSize; i++) {
            // 滑动窗口的思想，每次取目标数组大小进行比较，不符后再向后移动
            if (checkSubStr(ch, s.substring(i, i + targetCharSize))) {
                return i;
            }
        }
        return -1;

    }

    private boolean checkSubStr(char[] ch, String s) {
        for (char c : ch) {
            if (s.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
}
