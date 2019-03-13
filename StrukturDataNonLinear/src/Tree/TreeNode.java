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

    public TreeNode() {
    }

    public TreeNode(int element) {
        this.element = element;
        leftChild = rightChild = null;
    }
    
    public void insert(int x){
         if (x < element) {
            if (leftChild == null) {
                leftChild = new TreeNode(x);
            } else {
                leftChild.insert(x);
            }
        } else {
            if (rightChild == null) {
                rightChild = new TreeNode(x);
            } else {
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
}
