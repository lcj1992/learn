package tree.binary_tree;

import lombok.Data;
import lombok.Getter;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 下午9:51
 */
@Getter
@Data
public class BiTreeNode {

    private Integer val;

    private BiTreeNode left;

    private BiTreeNode right;

    public BiTreeNode(Integer val) {
        this.val = val;
    }

    public BiTreeNode(Integer val, BiTreeNode left, BiTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public BiTreeNode getLeft() {
        return left;
    }

    public void setLeft(BiTreeNode left) {
        this.left = left;
    }

    public BiTreeNode getRight() {
        return right;
    }

    public void setRight(BiTreeNode right) {
        this.right = right;
    }
}
