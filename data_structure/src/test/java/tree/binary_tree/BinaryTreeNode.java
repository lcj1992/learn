package tree.binary_tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 下午9:51
 */
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BinaryTreeNode {

    private Integer val;

    private BinaryTreeNode left;

    private BinaryTreeNode right;

    BinaryTreeNode(Integer val) {
        this.val = val;
    }
}
