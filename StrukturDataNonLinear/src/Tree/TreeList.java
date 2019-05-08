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
            root = new TreeNode(x, null);
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
                        bantu.leftChild = new TreeNode(x, bantu);
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
                        bantu.rightChild = new TreeNode(x, bantu);
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
    
    public boolean isRoot(int x){
        TreeNode bantu;
        getParent(x);
        bantu = getParent(x);
        if (bantu == null) {
            return true;
        }
        else {
            return false;
        }        
    }
    
    public boolean isLeaf(int x){
        TreeNode bantu;
        getNode(x);
        bantu = getNode(x);
        if ((bantu.leftChild == null) && (bantu.rightChild == null)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public TreeNode remove(int x){ // untuk menghapus simpul 0, 1 anak 
        TreeNode bantu = getNode(x);
        if (bantu == null) { // jika bantu adalah null atau bantu = null
            return null;
        }
        else {
            if (bantu.getElement() == getParent(bantu.getElement()).getElement()) { // Jika bantu adalah root atau bantu = root
                if (bantu.isLeaf()) { // Jika bantu adalah leaf atau bantu = leaf
                    root = null;
                }
                else if (bantu.rightChild == null) { // jika hanya punya anak kiri
                    root = bantu.leftChild;
                }
                else if (bantu.leftChild == null) { // jika hanya punya anak kanan
                    root = bantu.rightChild;
                }
            }
            else {
                if (bantu.getElement() < getParent(bantu.getElement()).getElement()) {
                    if (bantu.isLeaf()) { // Jika bantu adalah leaf atau bantu = leaf
                        getParent(bantu.getElement()).leftChild = null;
                    }
                    else if (bantu.rightChild == null) { // jika hanya punya anak kiri
                        getParent(bantu.getElement()).leftChild = bantu.leftChild;
                    }
                    else { // jika hanya punya anak kanan
                        getParent(bantu.getElement()).leftChild = bantu.rightChild;
                    }
                }
                else if (bantu.isLeaf()) { // Jika bantu adalah leaf atau bantu = leaf
                    getParent(bantu.getElement()).rightChild = null;
                }
                else if (bantu.rightChild == null) { // jika hanya punya anak kiri
                        getParent(bantu.getElement()).rightChild = bantu.leftChild;
                }
                else { // jika hanya punya anak kanan
                        getParent(bantu.getElement()).rightChild = bantu.rightChild;
                }
            }
        }
        return bantu; // kembalikan nilai bantu
    }
    
    public TreeNode remove2(int x){ // hapus 0, 1, 2 
        TreeNode bantu = getNode(x);
        if (bantu == null) { // jika bantu adalah null atau bantu = null
            return null;
        } 
        else { 
            if (bantu.isRoot()) { // Jika bantu adalah root atau bantu = root
                if (bantu.isLeaf()) { // Jika bantu adalah leaf atau bantu = leaf
                    root = null;
                }
                else if (bantu.rightChild == null) { // jika hanya punya anak kiri
                    root = bantu.leftChild;
                }
                else if (bantu.leftChild == null) { // jika hanya punya anak kanan
                    root = bantu.rightChild;
                }
                else { // jika punya dua anak
                    TreeNode prede = getPredecessor(bantu);
                    TreeNode parentPrede = prede.parent;
                    bantu.element = prede.element;
                    if (parentPrede != bantu) {
                        if (prede.getLeftChild() != null) {
                            parentPrede.rightChild = prede.leftChild;
                        }
                        else {
                            parentPrede.rightChild = null;
                        }
                    }
                    else {
                        bantu.leftChild = prede.leftChild;
                    }
                }
            }
            else {
                    if (bantu.isLeaf()) { // Jika bantu adalah leaf atau bantu = leaf
                        bantu.parent.leftChild = null;
                    }
                    else if (bantu.rightChild == null) { // jika hanya punya anak kiri
                        bantu.parent.leftChild = bantu.leftChild;
                    }
                    else if (bantu.leftChild == null) { // jika hanya punya anak kanan
                        bantu.parent.leftChild = bantu.rightChild;
                    }
                    else { // Jika bantu punya dua anak
                    TreeNode prede = getPredecessor(bantu);
                    TreeNode parentPrede = prede.parent;
                    bantu.element = prede.element;
                    if (parentPrede != bantu) {
                        if (prede.getLeftChild() != null) {
                            parentPrede.rightChild = prede.leftChild;
                        }
                        else {
                            parentPrede.rightChild = null;
                        }
                    }
                    else {
                        bantu.leftChild = prede.leftChild;
                    }
                }
            }
        }
        return bantu; // kembalikan nilai bantu
    }
    
    public TreeNode getParent(int x){
        // TreeNode bantu menunjuk ke root
        TreeNode bantu = root;
        // TreeNode parent menunjuk ke null
        TreeNode Parent = null;
        // selama bantu tidak sama dengan null
        while (bantu != null) {
            // jika x = bantu.getElement
            if (x == bantu.getElement()) {
                // kembalikan parent
                return Parent;
            }
            // jika x < bantu.getElement
            else if (x < bantu.getElement()) {
                // parent menunjuk ke bantu
                Parent = bantu;
                // bantu menunjuk ke bantu.leftChild
                bantu = bantu.leftChild;
            }
            // x > bantu.getElement
            else {
                // parent menunjuk ke bantu
                Parent = bantu;
                // bantu menunjuk/berpindah ke bantu.rightChild
                bantu = bantu.rightChild;
            }
        }
        // mengembalikan nilai null apabila hanya ada root
        return null;
    }
    
    public TreeNode getPredecessor(TreeNode x){
        TreeNode bantu = x; // menyimpan x ke bantu
        if (bantu.leftChild == null) { // mengecek bantu.leftChild == null
             return null; // mengembalikan nilai null
        }
        else {
            bantu = bantu.leftChild; // memindahkan bantu ke bantu.leftChild
            while (bantu.rightChild != null) { // looping selama bantu.rightChild tidak sama dengan null           
                if (bantu.rightChild == null) { // mengecek bantu.rightChild == null
                    return bantu; // mengembalikan nilai bantu
                } else {
                    bantu = bantu.rightChild; // memindahkan bantu ke bantu.rightChild
                }
            }
        }
        return bantu; // mengembalikan nilai bantu
    }
    
    public TreeNode getSuccessor(TreeNode x) {
        TreeNode bantu = x;
        if (bantu.rightChild == null) {
            return null;
        } else {
            bantu = bantu.rightChild;
            while(bantu.leftChild != null) {
                if (bantu.leftChild == null) {
                    return bantu;
                } else {
                    bantu = bantu.leftChild;
                }
            }
        }
        return bantu;
    }
}
