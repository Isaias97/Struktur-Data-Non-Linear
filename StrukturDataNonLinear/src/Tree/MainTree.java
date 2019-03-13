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
public class MainTree {
    public static void main(String[] args) {
        TreeList tl = new TreeList();
//        tl.add(23);
//        tl.add(19);
//        tl.add(5);
//        tl.add(45);
//        tl.add(35);
//        tl.add(65);
//        tl.add(33);
//        tl.add(42);
        tl.addR(23);
        tl.addR(19);
        tl.addR(5);
        tl.addR(45);
        tl.addR(35);
        tl.addR(65);
        tl.addR(33);
        tl.addR(42);
        tl.inOrderHelper();
        
    }
}
