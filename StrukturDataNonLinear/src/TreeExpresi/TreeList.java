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
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void addExpressionInfix(String data) {
        // menyiapkan objek dari Stack
        Stack operator = new Stack();
        Stack operand = new Stack();
        // menyiapkan variabel akar, kiri, dan kanan bertipe TreeNode
        TreeNode akar, kiri, kanan;
        // menyiapkan variable karakter bertipe char
        char karakter;
        
        
        for (int i = 0; i < data.length(); i++) {
            karakter = data.charAt(i);
            if (karakter == '(' || karakter == '+' || karakter == '-'
                    || karakter == '*' || karakter == '/') {
                TreeNode karakterNode = new TreeNode(karakter);
                operator.push(karakterNode);
            } else if (karakter == ')') {
                akar = operator.pop();
                while (akar.data != '(') {
                    kanan = operand.pop();
                    kiri = operand.pop();
                    operand.push(combine(kiri, kanan, akar));
                    akar = operator.pop();
                }
            } else {
                TreeNode karakterNode2 = new TreeNode(karakter);
                operand.push(karakterNode2);
            }
        }
        this.root = operand.pop();
    }

    public static TreeNode combine(TreeNode left, TreeNode right, TreeNode root) {
        root.leftChild = left;
        root.rightChild = right;
        return root;
    }

    public boolean isOperator(TreeNode operator) {
        if (operator.data == '/' || operator.data == '+' || operator.data == '-'
                || operator.data == '*') {
            return true;
        }
        return false;
    }

    public void infix(TreeNode localRoot) {
        if (localRoot != null) {
            if (!isOperator(localRoot)) {
                System.out.print(localRoot.data);
            } else {
                System.out.print('(');
                infix(localRoot.leftChild);
                System.out.print(localRoot.data + " ");
                infix(localRoot.rightChild);
                System.out.print(')');
            }

        }
    }
    
    private void postfix(TreeNode localRoot){
        if (localRoot != null) {
            postfix(localRoot.leftChild);
            postfix(localRoot.rightChild);
            System.out.print(localRoot.data + " ");
        }
    }
    
    private void prefix(TreeNode localRoot){
        if (localRoot != null) {
            System.out.print(localRoot.data + " ");
            prefix(localRoot.leftChild);
            prefix(localRoot.rightChild);
        }
    }
    
    public void prefixHelper(){
        System.out.print("Prefix : ");
        prefix(root);
        System.out.println("");
    }
    
    public void infixHelper() {
        System.out.print("Infix :");
        infix(root);
        System.out.println("");
    }
    
    public void postfixHelper(){
        System.out.print("Postfix : ");
        postfix(root);
        System.out.println("");
    }
}
