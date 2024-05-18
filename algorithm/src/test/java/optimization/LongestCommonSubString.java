package optimization;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/23
 * Time: 下午2:02
 */
public class LongestCommonSubString {

    public static void main(String[] args) {
        String str1 = "ider.cs@gmail.com";
        String str2 = "blog.iderzheng.com";
        System.out.println(longestCommonSubString(str1, str2));
    }

    private static long longestCommonSubString(String str1, String str2) {
        long longestLength = 0;
        int[][] table = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                boolean equal = str1.charAt(i) == str2.charAt(j);
                if (i == 0) {
                    if (equal) {
                        longestLength = 1;
                        table[0][j] = 1;
                    }
                    continue;
                }

                if (equal) {
                    if (j == 0) {
                        table[i][j] = 1;
                    } else {
                        table[i][j] = table[i - 1][j - 1] + 1;
                    }
                } else {
                    table[i][j] = 0;
                }

                if (table[i][j] > longestLength) {
                    longestLength = table[i][j];
                }
            }
        }
        return longestLength;
    }
}
