/**
 * @author lichuangjian
 * @date 2023/7/11
 */
public class ContainsNearbyDuplicateSolution {

    public static void main(String[] args) {
        ContainsNearbyDuplicateSolution solution = new ContainsNearbyDuplicateSolution();
        int[] numbers = new int[]{1, 2, 3, 1};
        boolean b = solution.containsNearbyDuplicate(numbers, 3);
        System.out.println(b);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= Math.min(i + k, nums.length - 1); j++) {
                if (nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
