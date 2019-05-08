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
public class MainTreeExpresi {
    public static void main(String[] args) {
        TreeList tree = new TreeList();
        String data = "((A+B)*C)";
        tree.addExpressionInfix(data);
        System.out.println("Mencetak pohon ekspresi : ");
        tree.prefixHelper();
        tree.infixHelper();
        tree.postfixHelper();
    }
}
