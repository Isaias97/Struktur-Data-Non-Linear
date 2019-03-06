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
public class TreeList {
    private TreeNode root;

    public TreeList() {
        root = null;
    }
    
    public void add(int x){
        // apakah root null 
        if (root == null) {
            // ya, root new TreeNode(x)
            
        }
        // tidak
        else {
            //bantu = root
            
            //selama bantu != null 
            while (true) {                
                // apakah x kurang dari bantu
                if (true) {
                    // ya, apakah bantu.leftChild  == null
                    if (true) {
                        // ya, bantu.leftChild = new TreeNode(x)
                        
                        // bantu = null
                    }
                    // tidak 
                    else {
                        // bantu = bantu.leftChild;
                    }
                }
                // tidak
                else {
                    // apakah bantu.rightChild  == null
                    if (true) {
                        // ya, bantu.rightChild = new TreeNode(x)
                        
                        // bantu = null;
                    }
                    // tidak
                    else {
                        // bantu = bantu.rightChild;
                    }
                }
            }        
        }
    }
    
    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
        
    private void preOrder(TreeNode localRoot){
        // apakah localRoot != null
        if (true) {
            // cetak localRoot.getElement
            
            // masukan localRoot.leftChild ke method preOrder
            
            // masukan localRoot.rightChild ke method preOrder
            
        }
    }
    
    private void inOrder(TreeNode localRoot){
        // apakah localRoot != null
        if (localRoot != null) {
            // masukan localRoot.leftChild ke method preOrder

            // cetak localRoot.getElement
           
            // masukan localRoot.rightChild ke method preOrder
            
        }
    }
    
    private void postOrder(TreeNode localRoot){
        // apakah localRoot != null
        if (localRoot != null) {
            // masukan localRoot.leftChild ke method preOrder
            
            // masukan localRoot.rightChild ke method preOrder
            
            // cetak localRoot.getElement
            
        }
    }
}
