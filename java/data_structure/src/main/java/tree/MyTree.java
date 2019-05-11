package tree;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 下午10:26
 */
public class MyTree<E> {
    private static final Integer MAX_TREE_SIZE = 100;

    private PTNode[] nodes;
    private int r;
    private int n;

    private static class PTNode<E> {
        E data;
        int parentIdx;
    }

    public MyTree(PTNode[] nodes, int r, int n) {
        this.nodes = nodes;
        this.r = r;
        this.n = n;
    }
}
