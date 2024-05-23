package leetcode;

import org.junit.Test;

public class Three6AddTest {

    @Test
    public void test36Add() {
        String num1 = "1Y"; // 表示36进制的1Y
        String num2 = "2Z"; // 表示36进制的2Z
        String sum = add(num1, num2);
        System.out.println("Sum in base 36: " + sum);
    }

    public static String add(String num1, String num2) {
        int carry = 0; // 进位
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += charToInt(num1.charAt(i));
                i--;
            }
            if (j >= 0) {
                sum += charToInt(num2.charAt(j));
                j--;
            }

            result.insert(0, intToChar(sum % 36));
            carry = sum / 36;
        }

        return result.toString();
    }

    private static int charToInt(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'A' && c <= 'Z') {
            return 10 + c - 'A';
        } else {
            throw new IllegalArgumentException("Invalid character: " + c);
        }
    }

    private static char intToChar(int num) {
        if (num >= 0 && num <= 9) {
            return (char) ('0' + num);
        } else if (num >= 10 && num <= 35) {
            return (char) ('A' + num - 10);
        } else {
            throw new IllegalArgumentException("Number out of range for base 36: " + num);
        }
    }
}
