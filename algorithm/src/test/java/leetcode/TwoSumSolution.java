package leetcode;

/**
 * @author lichuangjian
 * @date 2023/6/4
 */
public class TwoSumSolution {

    // 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
    // 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    // 你可以按任意顺序返回答案。
    public static void main(String[] args) {
        TwoSumSolution solution = new TwoSumSolution();
        int[] nums = new int[]{3, 2, 4};
        int[] ints = solution.twoSum(nums, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}


