package leetcode;

import common.TreeNode;
import org.junit.Test;

/**
 * @author lichuangjian
 * @date 2023/8/9
 */
public class SortedArrayToBSTTest {

    @Test
    public void test() {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortArray(nums, 0, nums.length - 1);
    }

    public TreeNode sortArray(int[] nums, int left, int right) {
        if (right == left) {
            return new TreeNode(nums[right]);
        }
        if (right - left == 1) {
            return new TreeNode(nums[left], null, new TreeNode(nums[right]));
        }
        TreeNode root = new TreeNode();
        int middle = (left + right) / 2;
        root.val = nums[middle];
        root.left = sortArray(nums, left, middle - 1);
        root.right = sortArray(nums, middle + 1, right);
        return root;
    }
}
