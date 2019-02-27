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
public class TreeList {
    private TreeNode root;

    public TreeList() {
        root = null;
    }
    
    public void add(int x){        
        if (root == null) {
            root = new TreeNode(x, null);
        }
        else {
            TreeNode bantu = root;
            while (bantu != null) {                
                if (x < bantu.getElement()) {
                    if (bantu.leftChild == null) {
                        bantu.leftChild = new TreeNode(x, bantu);
                        bantu = null;
                    }
                    else {
                        bantu = bantu.leftChild;
                    }
                }
                else {
                    if (bantu.rightChild == null) {
                        bantu.rightChild = new TreeNode(x, bantu);
                        bantu = null;
                    }
                    else {
                        bantu = bantu.rightChild;
                    }
                }
            }        
        }
    }
    
    public TreeNode remove(int x){ // untuk menghapus simpul 0, 1 anak 
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
            }
            else {
                if (bantu.getElement() < bantu.getParent().getElement()) {
                    if (bantu.isLeaf()) { // Jika bantu adalah leaf atau bantu = leaf
                        bantu.getParent().leftChild = null;
                    }
                    else if (bantu.rightChild == null) { // jika hanya punya anak kiri
                        bantu.getParent().leftChild = bantu.leftChild;
                    }
                    else { // jika hanya punya anak kanan
                        bantu.getParent().leftChild = bantu.rightChild;
                    }
                }
                else if (bantu.isLeaf()) { // Jika bantu adalah leaf atau bantu = leaf
                    bantu.getParent().rightChild = null;
                }
                else if (bantu.rightChild == null) { // jika hanya punya anak kiri
                        bantu.getParent().rightChild = bantu.leftChild;
                }
                else { // jika hanya punya anak kanan
                        bantu.getParent().rightChild = bantu.rightChild;
                }
            }
        }
        return bantu; // kembalikan nilai bantu
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    public TreeNode getNode(int x){
        TreeNode bantu = getRoot();
        while (bantu != null) {            
            if (bantu.getElement() == x) {
                return bantu;
            }
            else if (x < bantu.getElement()) {
                bantu = bantu.leftChild;
            }
            else {
                bantu = bantu.rightChild;
            }
        }
        return null;
    }
    
    private void preOrder(TreeNode localRoot){
        if (localRoot != null) {
            System.out.print(localRoot.getElement() + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
    
    private void inOrder(TreeNode localRoot){
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.getElement() + " ");
            inOrder(localRoot.rightChild);
        }
    }
    
    private void postOrder(TreeNode localRoot){
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.getElement() + " ");
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
    
    public TreeNode getParent(int x){
        TreeNode bantu = root;
        TreeNode parent = null;
        while (bantu != null) {            
            if (x == bantu.getElement()) {
                return parent;
            }
            else if (x < bantu.getElement()) {
                parent = bantu;
                bantu = bantu.leftChild;
            }
            else {
                parent = bantu;
                bantu = bantu.rightChild;
            }
        }
        return null;
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
    
//    public TreeNode getPredecessor(TreeNode x) {
//        TreeNode bantu = x  ;
//        if (bantu.leftChild == null) {
//            return null;
//        } else {
//            bantu = bantu.leftChild;
//            while(bantu.rightChild == null) {
//                if (bantu.rightChild == null) {
//                    return bantu;
//                } else {
//                    bantu = bantu.rightChild;
//                }
//            }
//        }
//        return bantu;
//    }
    
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
                    TreeNode parentPrede = prede.getParent();
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
                        bantu.getParent().leftChild = null;
                    }
                    else if (bantu.rightChild == null) { // jika hanya punya anak kiri
                        bantu.getParent().leftChild = bantu.leftChild;
                    }
                    else if (bantu.leftChild == null) { // jika hanya punya anak kanan
                        bantu.getParent().leftChild = bantu.rightChild;
                    }
                    else { // Jika bantu punya dua anak
                    TreeNode prede = getPredecessor(bantu);
                    TreeNode parentPrede = prede.getParent();
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
    
    public void addExpressionInfix(String data){
        Stack operator = new Stack();
        Stack operad = new Stack();
        TreeNode akar, kanan, kiri;
        char karakter;
        
        for (int i = 0; i < data.length(); i++) {
            karakter = data.charAt(i);
            if (karakter == ('{') || karakter == '+' || karakter == '-' ||
                    karakter == '*' || karakter == '/') {
                TreeNode karakterNode = new TreeNode(karakter);
                operator.push(karakterNode);
            }
            else if (karakter == '}') {
                akar = operator.pop();
                while (akar.data != '{') {                    
                    kanan = operad.pop();
                    kiri = operad.pop();
                    operad.push(combine(akar, kiri, kanan));
                    akar = operator.pop();
                }
            }
            else {
                TreeNode karakaterNode2 = new TreeNode(karakter);
                operad.push(karakaterNode2);
            }
        }
        root = operad.pop();
    }
    
    public TreeNode combine(TreeNode left, TreeNode right, TreeNode root){
        root.leftChild = left;
        root.rightChild = right;
        return null;
    }
    
    private void infix(TreeNode localRoot){
        if (localRoot != null) {
            if (isLeaf(0)) {
                System.out.print(localRoot.getData() + " ");
            }
            else {
                System.out.print(localRoot.getData() + " ");
                infix(localRoot.leftChild);
                System.out.print(localRoot.getData() + " ");
                infix(localRoot.rightChild);
            }
        }
    }
    
    private void postfix(TreeNode localRoot){
        if (localRoot != null) {
            postfix(localRoot.leftChild);
            postfix(localRoot.rightChild);
            System.out.print(localRoot.getData() + " ");
        }
    }
    
    private void prefix(TreeNode localRoot){
        if (localRoot != null) {
            System.out.print(localRoot.getData() + " ");
            prefix(localRoot.leftChild);
            prefix(localRoot.rightChild);
        }
    }
    
    public void prefixHelper(){
        System.out.print("Pre Order : ");
        prefix(root);
        System.out.println("");
    }
    
    public void infixHelper(){
        System.out.print("In Order : ");
        infix(root);
        System.out.println("");
    }
    
    public void postfixHelper(){
        System.out.print("Post Order : ");
        postfix(root);
        System.out.println("");
    }
}
