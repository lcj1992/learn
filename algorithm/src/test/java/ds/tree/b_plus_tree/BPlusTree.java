package ds.tree.b_plus_tree;


/**
 * Desc: https://blog.csdn.net/lijiecao0226/article/details/24191543
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/8
 * Time: 上午8:59
 */
public class BPlusTree<K extends Comparable<K>, V> {
    /**
     * 根节点
     */
    private BPlusNode<K, V> root;

    /**
     * 阶数，M值
     */
    private int order;

    /**
     * 叶子节点的链表头
     */
    private BPlusNode<K, V> head;

    /**
     * 树高
     */
    private int height = 0;

    public BPlusNode<K, V> getHead() {
        return head;
    }

    public void setHead(BPlusNode<K, V> head) {
        this.head = head;
    }

    public BPlusNode<K, V> getRoot() {
        return root;
    }

    public void setRoot(BPlusNode<K, V> root) {
        this.root = root;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public V get(K key) {
        return root.get(key);
    }

    public V remove(K key) {
        return root.remove(key, this);
    }

    public void insertOrUpdate(K key, V value) {
        root.insertOrUpdate(key, value, this);

    }

    public BPlusTree(int order) {
        if (order < 3) {
            System.out.print("order must be greater than 2");
            System.exit(0);
        }
        this.order = order;
        root = new BPlusNode<>(true, true);
        head = root;
    }

}
