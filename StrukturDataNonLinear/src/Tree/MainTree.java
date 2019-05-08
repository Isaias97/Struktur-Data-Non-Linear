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
        tl.addR(23);
        tl.addR(19);
        tl.addR(5);
        tl.addR(45);
        tl.addR(35);
        tl.addR(65);
        tl.addR(33);
        tl.addR(42);
        
        System.out.println("Sebelum hapus");
        tl.preOrderHelper();
        tl.inOrderHelper();
        tl.postOrderHelper();
        
        int x = 45;
        System.out.println("Mencari predecessor dari "+ x +" di Binary Tree");
        TreeNode prede = tl.getPredecessor(tl.getNode(x));
        if(prede == null){
            System.out.println("Data tidak ada");
        }else{
            System.out.println("Data ditemukan = "+prede.getElement());
        }
        int y = 19,z = 45, v = 35;
        TreeNode parent = tl.getParent(z);
        System.out.println("Parent dari simpul "+ z +" adalah " + parent.getElement());
        System.out.println(z + " adalah root : " + tl.isRoot(z));
        System.out.println(v + " adalah leaf : " + tl.isLeaf(v));
        System.out.println("");
        tl.remove2(x);
        System.out.println("Bukti bahwa " + x + " telah dihapus");
        tl.preOrderHelper();
        tl.inOrderHelper();
        tl.postOrderHelper();        
    }
}
