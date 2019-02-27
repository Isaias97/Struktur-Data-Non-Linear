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

    public TreeNode() {
    }

    public TreeNode(int element, TreeNode parent) {
        this.element = element;
        leftChild = rightChild = null;
        this.parent = parent;
    }

    public TreeNode(char data, TreeNode parent) {
        this.data = data;
        leftChild = rightChild = null;
        this.parent = parent;
    }

    public TreeNode(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
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
    
    public boolean isLeaf(){
        return ((leftChild == null) && (rightChild == null));
    }
    
    public boolean isRoot(){
        return parent == null;
    }
}
