package tree;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Desc: 树的遍历
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/18
 * Time: 下午6:58
 */
public class TreeTraverseSolution {

    @Test
    public void testLevelOrder() {
        TreeNode node = initTree();
        List<List<TreeNode>> lists = levelOrder(node);
        lists.forEach(each -> each.forEach(eachNode -> System.out.println(eachNode.getVal())));
        Assert.assertEquals(6, lists.stream().mapToInt(List::size).max().getAsInt());
    }

    @Test
    public void testPreOrder() {
        TreeNode node = initTree();
        List<Integer> integers = preOrder(node);
        String result = integers.stream().map(String::valueOf).collect(Collectors.joining());
        Assert.assertEquals("12567384910", result);
    }

    @Test
    public void testPostOrder() {
        TreeNode node = initTree();
        List<Integer> integers = postOrder(node);
        String result = integers.stream().map(String::valueOf).collect(Collectors.joining());
        Assert.assertEquals("56728391041", result);
    }

    private TreeNode initTree() {
        TreeNode node10 = new TreeNode(10);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4, Lists.newArrayList(node9, node10));
        TreeNode node3 = new TreeNode(3, Lists.newArrayList(node8));
        TreeNode node2 = new TreeNode(2, Lists.newArrayList(node5, node6, node7));
        return new TreeNode(1, Lists.newArrayList(node2, node3, node4));
    }


    private List<Integer> preOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.add(root.getVal());
        if (root.getChildren() != null && !root.getChildren().isEmpty()) {
            for (TreeNode node : root.getChildren()) {
                result.addAll(preOrder(node));
            }
        }
        return result;
    }

    private List<Integer> postOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        if (root.getChildren() != null && !root.getChildren().isEmpty()) {
            for (TreeNode node : root.getChildren()) {
                result.addAll(postOrder(node));
            }
        }
        result.add(root.getVal());
        return result;
    }

    private List<List<TreeNode>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return Lists.newArrayList();
        }
        List<List<TreeNode>> results = Lists.newArrayList();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 一层的结果集
            List<TreeNode> levelResult = Lists.newArrayList();
            // 每一层的节点个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // 将该层的每个节点的值加入该层结果集中
                levelResult.add(poll);
                List<TreeNode> children = poll.getChildren();
                if (Objects.nonNull(children) && !children.isEmpty()) {
                    children.forEach(queue::offer);
                }
            }
            results.add(levelResult);
        }
        return results;
    }
}