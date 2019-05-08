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
    int element;
    TreeNode rightChild;
    TreeNode leftChild;
    TreeNode parent;

    public TreeNode() {
    }

    public TreeNode(int element) {
        this.element = element;
        leftChild = rightChild = null;
    }
    
    public TreeNode(int element, TreeNode parent) {
        this.element = element;
        leftChild = rightChild = null;
        this.parent = parent;
    }
    
    public void insert(int x){
        // cek x < element
        if (x < element) {
            // jika ya, cek leftChild == null
            if (leftChild == null) {
                // jika ya, leftChild = new TreeNode(x)
                leftChild = new TreeNode(x, this);
            } else {
                // jika tidak, leftChild.insert(x)
                leftChild.insert(x);
            }
        }
        else {
            // jika tidak, cek rightChild == null
            if (rightChild == null) {
                // jika ya, rightChild.insert(x)
                rightChild = new TreeNode(x, this);
            } else {
                // jika tidak, rightChild.insert(x)
                rightChild.insert(x);
            }
        }
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
    
    public boolean isLeaf(){
        return ((leftChild == null) && (rightChild == null));
    }
    
    public boolean isRoot(){
        return parent == null;
    }
    
    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
