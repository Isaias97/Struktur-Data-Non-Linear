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
import java.util.LinkedList;
public class Stack {
    LinkedList<TreeNode> tumpukan;

    public Stack(){
        tumpukan = new LinkedList<>();
    }
    
    public void push(TreeNode bantu){
        tumpukan.addFirst(bantu);
    }
    
    public TreeNode pop(){
        return tumpukan.removeFirst();
    }
}
