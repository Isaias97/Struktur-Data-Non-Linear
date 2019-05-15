/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.ArrayList;

/**
 *
 * @author Aureli Isaias
 */
public class Main {
    public static void main(String[] args) {
        Graph02 graph = new Graph02();
        
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
//        graph.addVertex('E');
//        graph.addVertex('F');
//        graph.addVertex('G');
//        graph.addVertex('H');
//        graph.addVertex('I');
        
        graph.addEdge('A', 'B', 8);
        graph.addEdge('A', 'D', 3);
        graph.addEdge('A', 'C', 7);
        graph.addEdge('B', 'D', 5);
        graph.addEdge('B', 'C', 4);
        graph.addEdge('C', 'D', 6);
//        graph.addEdge('D', 'E', 15);
//        graph.addEdge('D', 'F', 6);
//        graph.addEdge('E', 'F', 8);
//        graph.addEdge('E', 'G', 9);
//        graph.addEdge('F', 'G', 11);
        
        ArrayList<Edge> hasil = graph.prim();
        int sum = 0;
        
        for (int i = 0; i < hasil.size(); i++) {
            System.out.println(hasil.get(i));
            sum = sum + hasil.get(i).getWeight();
        }
        
        System.out.println("Total = " + sum);
//        graph.addEdge('E', 'G', 80);
//        graph.addEdge('G', 'D', 80);
        
        graph.printaddjecency();
//        System.out.println("");
//        System.out.println("Breadth First Search : ");
//        graph.breadthFirstSearch();
    }
}
