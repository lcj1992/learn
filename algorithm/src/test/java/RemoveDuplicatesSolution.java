/**
 * @author lichuangjian
 * @date 2023/8/8
 */
public class RemoveDuplicatesSolution {

    public static void main(String[] args) {
        RemoveDuplicatesSolution solution = new RemoveDuplicatesSolution();
        int result = solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(result);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            // 不等 才加
            if (nums[i] != nums[i - 1]) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}
