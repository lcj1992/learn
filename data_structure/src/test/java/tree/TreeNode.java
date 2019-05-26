package tree;

import lombok.Data;

import java.util.List;

/**
 * Desc: 多叉树节点
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/18
 * Time: 下午7:31
 */
@Data
class TreeNode {

    private int val;

    private List<TreeNode> children;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, List<TreeNode> children) {
        this.val = val;
        this.children = children;
    }
}
