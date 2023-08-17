/**
 * https://leetcode.cn/problems/single-number/solutions/242211/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
 * 只出现一次的数字
 *
 * @author lichuangjian
 * @date 2023/8/17
 */
public class SingleNumberSolution {

    public static void main(String[] args) {
        SingleNumberSolution solution = new SingleNumberSolution();
        int[] input = {2, 2, 1};
        int res = solution.singleNumber(input);
        System.out.println(res);
    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
