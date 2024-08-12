package ds.tree.binary_tree;

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
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }
}
