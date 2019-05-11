package tree;

import lombok.Getter;

import java.util.Scanner;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 下午9:51
 */
public class MyBinaryTree {

    @Getter
    private BinaryNode<Integer> root;

    private static class BinaryNode<E> {
        E element;

        BinaryNode<E> left;

        BinaryNode<E> right;

        private BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

    }

    public MyBinaryTree() {
        this.root = new BinaryNode<>(null, null, null);
    }

    public void createTree(BinaryNode<Integer> root) {
        Scanner sc = new Scanner(System.in);
        Integer next = sc.nextInt();
        if (next != -1) {
            root.element = next;
            root.left = new BinaryNode<>(null, null, null);
            createTree(root.left);
            root.right = new BinaryNode<>(null, null, null);
            createTree(root.right);
        }
    }

    public static void main(String[] args) {
        MyBinaryTree binaryTree = new MyBinaryTree();
        binaryTree.createTree(binaryTree.getRoot());
    }
}
