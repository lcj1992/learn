package algo.divide;

import common.TreeNode;
import common.Utils;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/">...</a>
 * 二叉树的序列化和反序列化
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class SerializableTreeTest {


    @Test
    public void test() {
        TreeNode treeNode = TreeNode.create(1, 2, 3, null, null, 4, 5);
        Codec codec = new Codec();
        String serialize = codec.serialize(treeNode);
        System.out.println(serialize);
        treeNode = codec.deserialize(serialize);
        Utils.printTree(treeNode);
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            StringBuilder res = new StringBuilder("[");
            while (!deque.isEmpty()) {
                TreeNode node = deque.removeFirst();
                if (node != null) {
                    res.append(node.val).append(",");
                    deque.addLast(node.left);
                    deque.addLast(node.right);
                } else {
                    res.append("null,");
                }
            }
            res.deleteCharAt(res.length() - 1);
            res.append("]");
            return res.toString();

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("[]".equals(data)) {
                return null;
            }
            String[] valArr = data.substring(1, data.length() - 1).split(",");
            Deque<TreeNode> deque = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(valArr[0]));
            deque.add(root);
            int i = 1;
            while (!deque.isEmpty()) {
                TreeNode node = deque.removeFirst();
                if (!valArr[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(valArr[i]));
                    deque.addLast(node.left);
                }
                i++;
                if (!valArr[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(valArr[i]));
                    deque.addLast(node.right);
                }
                i++;
            }
            return root;
        }
    }

}
