import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/15
 * Time: 下午4:30
 */
public class MaxSizeTest {

    @AllArgsConstructor
    @Getter
    public class TreeNode {
        private int value;
        private List<TreeNode> children;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public int maxSize(TreeNode root) {
        if (CollectionUtils.isEmpty(root.getChildren())) {
            return 1;
        }
        int maxSize = 0;
        List<TreeNode> children = root.getChildren();
        int currentLevelSize = 0;
        for (TreeNode child : children) {
            int eachChildSize = maxSize(child);
            currentLevelSize += eachChildSize;
        }
        return maxSize > currentLevelSize ? maxSize : currentLevelSize;
    }

    @Test
    public void test() {
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4, Lists.newArrayList(treeNode9, treeNode10));
        TreeNode treeNode3 = new TreeNode(3, Lists.newArrayList(treeNode8));
        TreeNode treeNode2 = new TreeNode(2, Lists.newArrayList(treeNode5, treeNode6, treeNode7));
        TreeNode treeNode1 = new TreeNode(1, Lists.newArrayList(treeNode2, treeNode3, treeNode4));
        int maxSize = maxSize(treeNode1);
        Assert.assertEquals(6, maxSize);
    }


    @Data
    public class ListNode {
        int value;

        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }


    public ListNode getReserveIdxNode(ListNode listNode, int reserveIdx) {
        int size = getListSize(listNode);

        int idx = size - reserveIdx + 1;

        size = 0;
        ListNode tmp = listNode;
        while (Objects.nonNull(tmp)) {
            if (size == idx) {
                return tmp;
            }
            size++;
        }
        return null;
    }

    private int getListSize(ListNode listNode) {
        int size = 0;
        ListNode tmp = listNode;
        while (Objects.nonNull(tmp)) {
            size++;
            tmp = tmp.getNext();
        }
        return size;
    }

    @Test
    public void test1() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        ListNode reserveIdxNode = getReserveIdxNode(listNode1, 3);

        Assert.assertEquals(getListSize(listNode1), 4);
        Assert.assertEquals(getListSize(listNode2), 3);
        Assert.assertEquals(reserveIdxNode.getValue(), 2);
    }
}
