package ds.tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

import common.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">...</a>
 * 从前序与中序遍历序列构造二叉树
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class BuildTreeTest {

    @Test
    public void test() {
        TreeNode result = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        Utils.print(result);
    }


    /**
     * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/2361558/105-cong-qian-xu-yu-zhong-xu-bian-li-xu-4lvkz/">...</a>
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        // 前序遍历的顺序：根左右，前序遍历数组的第一个节点即为根节点
        return buildTree(preorder, inorderMap, 0, 0, inorder.length - 1);
    }

    /**
     * @param preorder   前序遍历数组
     * @param inorderMap 中序遍历数组map，key为节点，value为节点在中序遍历数组的下标
     * @param preRootId  根节点在前序遍历的数组下标
     * @param inLeftId   中序遍历数组的起始下标索引
     * @param inRightId  中序遍历数组的截止下标索引
     */
    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap, int preRootId, int inLeftId, int inRightId) {
        if (inLeftId > inRightId) {
            return null;
        }
        // 前序遍历的顺序：根左右
        TreeNode tree = new TreeNode(preorder[preRootId]);
        // 找到根节点在中序遍历数组的下标
        // 划分根节点、左子树、右子树，该下标左侧即为左子树，右侧即为右子树
        int inRootId = inorderMap.get(preorder[preRootId]);
        // 递归构建左子树
        // 左子树的根节点在前序遍历
        // 左子树根节点在前序遍历数组中的下标=根节点的下标+1
        // 左子树的对应中序遍历数组的最右侧下标为根节点在中序遍历数组的下标-1
        tree.left = buildTree(preorder, inorderMap, preRootId + 1, inLeftId, inRootId - 1);
        // 递归构建右子树
        // 右子树根节点在前序遍历数组中的下标=根节点数组下标+左子树长度+1，左子树长度=i - left
        // 右子树的对应中序遍历数组的最左侧下标为根节点在中序遍历数组的下标+1
        tree.right = buildTree(preorder, inorderMap, preRootId + (inRootId - inLeftId) + 1, inRootId + 1, inRightId);
        return tree;
    }


}


