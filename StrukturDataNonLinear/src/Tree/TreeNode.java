/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author Aureli Isaias
 */
public class TreeNode {
    private int element;
    private TreeNode rightChild;
    private TreeNode leftChild;
    private TreeNode parent;
    private char data;

    public TreeNode() {
    }

    public TreeNode(int element, TreeNode parent) {
        this.element = element;
         leftChild = rightChild = null;
        this.parent = parent;
    }

    public TreeNode(TreeNode parent, char data) {
        this.parent = parent;
        leftChild = rightChild = null;
        this.data = data;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }
}
