package ds.tree.binary_tree;

import common.TreeNode;
import common.Utils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">...</a>
 */
public class BuildTree2Test {

    @Test
    public void test() {
        TreeNode result = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        Utils.print(result);
    }


    /**
     * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/2361558/105-cong-qian-xu-yu-zhong-xu-bian-li-xu-4lvkz/">...</a>
     */
    public TreeNode buildTree(int[] inorder, int[] postOrder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        // 后序遍历的顺序：左右根，前序遍历数组的第一个节点即为根节点
        return buildTree(postOrder, inorderMap, postOrder.length - 1, 0, inorder.length - 1);
    }

    /**
     * @param postorder  后序遍历数组
     * @param inorderMap 中序遍历数组map，key为节点，value为节点在中序遍历数组的下标
     * @param postRootId 根节点在后序遍历的数组下标
     * @param inLeftId   中序遍历数组的起始下标索引
     * @param inRightId  中序遍历数组的截止下标索引
     */
    private TreeNode buildTree(int[] postorder, Map<Integer, Integer> inorderMap, int postRootId, int inLeftId, int inRightId) {
        if (inLeftId > inRightId) {
            return null;
        }
        // 前序遍历的顺序：根左右
        TreeNode tree = new TreeNode(postorder[postRootId]);
        // 找到根节点在中序遍历数组的下标
        // 划分根节点、左子树、右子树，该下标左侧即为左子树，右侧即为右子树
        int inRootId = inorderMap.get(postorder[postRootId]);
        // 递归构建左子树
        // 左子树根节点在后序遍历数组中的下标=根节点数组下标-右子树长度-1，右子树长度=inRightId-inRootId
        // 左子树的对应中序遍历数组的最右侧下标为根节点在中序遍历数组的下标-1
        tree.left = buildTree(postorder, inorderMap, postRootId - (inRightId - inRootId) - 1, inLeftId, inRootId - 1);
        // 递归构建右子树
        // 右子树根节点在前序遍历数组中的下标=根节点数组下标-1
        // 右子树的对应中序遍历数组的最左侧下标为根节点在中序遍历数组的下标+1
        tree.right = buildTree(postorder, inorderMap, postRootId - 1, inRootId + 1, inRightId);
        return tree;
    }
}
