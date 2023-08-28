/**
 * @author lichuangjian
 * @date 2023/8/24
 */
public class TitleToNumberSolution {

    public static void main(String[] args) {
        TitleToNumberSolution solution = new TitleToNumberSolution();
        System.out.println(solution.titleToNumber("ZY"));
    }

    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int res = 0;
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            int num = c - 'A' + 1;
            res += num * (int) Math.pow(26, length - i - 1);
        }
        return res;
    }
}
