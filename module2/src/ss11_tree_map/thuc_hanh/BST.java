package ss11_tree_map.thuc_hanh;

import ss11_tree_map.thuc_hanh.AbstractTree;
import ss11_tree_map.thuc_hanh.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); /*create a new root*/
        else {
            /*locate the parent node*/
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; /*element inserted successfully*/
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    public void postorder() {
        postorder(root);
    }


    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    protected void postorder(TreeNode<E> root) {
//        if (root == null) return;
//        while (root.left != null) {
//            stack.add(root.left.element);
//            postorder(root.left, stack, queue);
//        }
//        while (!stack.isEmpty()) {
//            queue.add(stack.pop());
//        }
//        while (root.right != null) {
//            stack.add(root.right.element);
//            postorder(root.right, stack, queue);
//        }
//        while (!stack.isEmpty()) {
//            queue.add(stack.pop());
//        }
    }


}