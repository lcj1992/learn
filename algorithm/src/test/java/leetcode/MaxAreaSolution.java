package leetcode;

/**
 * @author lichuangjian
 * @date 2023/6/28
 */
public class MaxAreaSolution {

    public static void main(String[] args) {
        MaxAreaSolution solution = new MaxAreaSolution();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = solution.maxArea(height);
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int result = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            int l = j - i;
            result = Math.max(result, l * h);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
