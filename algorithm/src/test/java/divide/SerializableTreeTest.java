package divide;

import common.TreeNode;
import common.Utils;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        public String serialize(TreeNode root) {
            return serialize(root, "");
        }

        public TreeNode deserialize(String data) {
            String[] dataArray = data.split(",");
            List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
            return deserialize(dataList);
        }

        public String serialize(TreeNode root, String str) {
            if (root == null) {
                str += "None,";
            } else {
                str += root.val + ",";
                str = serialize(root.left, str);
                str = serialize(root.right, str);
            }
            return str;
        }

        public TreeNode deserialize(List<String> dataList) {
            if (dataList.get(0).equals("None")) {
                dataList.remove(0);
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
            dataList.remove(0);
            root.left = deserialize(dataList);
            root.right = deserialize(dataList);

            return root;
        }
    }

}
