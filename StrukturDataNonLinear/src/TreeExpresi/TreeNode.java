/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeExpresi;

/**
 *
 * @author Aureli Isaias
 */
public class TreeNode {
    int element;
    TreeNode rightChild;
    TreeNode leftChild;
    TreeNode parent;
    char data;

    public TreeNode(char data) {
        this.data = data;
    }

    public TreeNode(TreeNode left, TreeNode right) {
        this.leftChild = left;
        this.rightChild = right;
    }

    public TreeNode(char elemen, TreeNode parent) {
        this.data = elemen;
        this.parent = parent;
        leftChild = rightChild = null;
    }

    public char getElemen() {
        return data;
    }

    public void setElemen(char elemen) {
        this.data = elemen;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public boolean isLeaf() {
        return (leftChild == null && rightChild == null);
    }

    public boolean isParent() {
        return (leftChild != null || rightChild != null);
    }

    public boolean isRoot() {
        return (parent == null);
    }
}
