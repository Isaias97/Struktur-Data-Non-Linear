/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;
import Tree.TreeNode;
/**
 *
 * @author Aureli Isaias
 */
public class TreeList {
     TreeNode root;

    public TreeList() {
        root = null;
    }
    
    public TreeNode getRoot() {
        // mengembalikan nilai root
        return root;
    }
    
    public void add(int x){
        // apakah root null 
        if (root == null) {
            // ya, root new TreeNode(x)
            root = new TreeNode(x);
        }
        // tidak
        else {
            //bantu = root
            TreeNode bantu = root;
            //selama bantu != null 
            while (bantu != null) {                
                // apakah x kurang dari bantu
                if (x < bantu.getElement()) {
                    // ya, apakah bantu.leftChild  == null
                    if (bantu.leftChild == null) {
                        // ya, bantu.leftChild = new TreeNode(x)
                        bantu.leftChild = new TreeNode(x);
                        // bantu = null
                        bantu = null;
                    }
                    // tidak 
                    else {
                        // bantu = bantu.leftChild;
                        bantu = bantu.leftChild;
                    }
                }
                // tidak
                else {
                    // apakah bantu.rightChild  == null
                    if (bantu.rightChild == null) {
                        // ya, bantu.rightChild = new TreeNode(x)
                        bantu.rightChild = new TreeNode(x);
                        // bantu = null;
                        bantu = null;
                    }
                    // tidak
                    else {
                        // bantu = bantu.rightChild;
                        bantu = bantu.rightChild;
                    }
                }
            }        
        }
    }
    
    public void addR(int x){
        if(isEmpty()){
            root = new TreeNode(x);
        }else{
            root.insert(x);
        }
    }
    

    public boolean isEmpty(){
        if(root == null){
            return true;
        }else{
            return false;
        }
    }
    public TreeNode getNode(int x){
        // TreeNode bantu menunjuk ke root
        TreeNode bantu = getRoot();
        // selama bantu tidak null
        while (bantu != null) {   
            // jika ya, cek element = x
            if (bantu.getElement() == x) {
                // jika ya, return bantu
                return bantu;
            }
            // jika tidak, cek x < element 
            else if (x < bantu.getElement()) {
                // jika ya, bantu berpindah ke leftChild
                bantu = bantu.leftChild;
            }
            else {
                // jika tidak, bantu berpindah ke rightChild
                bantu = bantu.rightChild;
            }
        }
        // jika tidak ketemu, return null
        return null;
    }
    
    
    
    private void preOrder(TreeNode localRoot){
        // apakah localRoot != null
        if (localRoot!= null) {
            // cetak localRoot.getElement
            System.out.print(localRoot.getElement() + " ");
            // masukan localRoot.leftChild ke method preOrder
            preOrder(localRoot.leftChild);
            // masukan localRoot.rightChild ke method preOrder
            preOrder(localRoot.rightChild);
            
        }
    }
    
    public void preOrderHelper(){
        System.out.print("Pre Order : ");
        preOrder(root);
        System.out.println("");
    }
    
    public void inOrderHelper(){
        System.out.print("In Order : ");
        inOrder(root);
        System.out.println("");
    }
    
    public void postOrderHelper(){
        System.out.print("Post Order : ");
        postOrder(root);
        System.out.println("");
    }
    
    private void inOrder(TreeNode localRoot){
        // apakah localRoot != null
        if (localRoot != null) {
            // masukan localRoot.leftChild ke method preOrder
            inOrder(localRoot.leftChild);
            // cetak localRoot.getElement
            System.out.print(localRoot.getElement() + " ");
            // masukan localRoot.rightChild ke method preOrder
            inOrder(localRoot.rightChild);
        }
    }
    
    private void postOrder(TreeNode localRoot){
        // apakah localRoot != null
        if (localRoot != null) {
            // masukan localRoot.leftChild ke method preOrder
            postOrder(localRoot.leftChild);
            // masukan localRoot.rightChild ke method preOrder
            postOrder(localRoot.rightChild);
            // cetak localRoot.getElement
            System.out.print(localRoot.getElement() + " ");
        }
    }
}
