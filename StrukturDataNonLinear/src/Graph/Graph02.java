/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
/**
 *
 * @author Aureli Isaias
 */
public class Graph02 {
    int maxVertex = 10;
    Vertex [] vertexList;
    int [][] adjacencyMatrik;
    int countVertex = 0;

    public Graph02() {
        vertexList = new Vertex[maxVertex];
        adjacencyMatrik = new int [maxVertex] [maxVertex];
        countVertex = 0;
        for (int i = 0; i < vertexList.length; i++) {
            for (int j = 0; j < vertexList.length; j++) {
                if (i == j) {
                    adjacencyMatrik[i][j] = 0;
                }
                else {
                    adjacencyMatrik[i][j] = -1;
                }
            }
        }
    }
    
    public void addVertex(char node){
        vertexList[countVertex++] = new Vertex(node); 
    }
    
    public void addEdge(int x, int y, int z){
        adjacencyMatrik[x][y] = z;
        adjacencyMatrik[y][x] = z;
        
    }
    
    public void addEdge(char x, char y, int z){
        adjacencyMatrik[indexVertex(x)][indexVertex(y)] = z;
        adjacencyMatrik[indexVertex(y)][indexVertex(x)] = z;
    }
    
    public int indexVertex(char index){
        for (int i = 0; i < countVertex; i++) {
            if (vertexList[i].label == index) {
                return i;
            }
        }
        return -1;
    }
    
    public void printaddjecency(){
        for (int baris = 0; baris < countVertex; baris++) {
            for (int kolom = 0; kolom < countVertex; kolom++) {
                System.out.printf(adjacencyMatrik[baris][kolom]+" ");
            }
            System.out.println("");
        }
    }
    
    public int getWeight(char x, char y){
        return adjacencyMatrik[indexVertex(x)][indexVertex(y)];
    }    
    
    public void depthFirstSearch(){
        Vertex seed = vertexList[0];
        Stack stack = new Stack();
        stack.push(seed);
        while (!stack.empty()) {            
            Vertex x = (Vertex) stack.pop();
            if (x.flagVisited == false) {
                System.out.print(x.label + " ");
                x.flagVisited = true;
                for (int i = countVertex - 1; i >= 0; i--) {
                    if (adjacencyMatrik[indexVertex(x.label)][i] > 0) {
                        stack.push(vertexList[i]);
                    }
                }
            }
        }
    }
    
    public void breadthFirstSearch(){
        Vertex seed = vertexList[0];
        LinkedList antrian = new LinkedList();
        antrian.addLast(seed);
        while (!antrian.isEmpty()) {            
            Vertex x = (Vertex) antrian.removeFirst();
            if (x.flagVisited == false) {
                System.out.print(x.label + " ");
                x.flagVisited = true;
                for (int i = 0; i <= countVertex; i++) {
                    if (adjacencyMatrik[indexVertex(x.label)][i] > 0) {
                        antrian.addLast(vertexList[i]);
                    }
                }
            }
        }
    }
    
    public void reset(){
        for (int i = 0; i < countVertex; i++) {
            for (int j = 0; j < countVertex; j++) {
                if (adjacencyMatrik[i][j] > -1 && vertexList[i].flagVisited == true) {
                    vertexList[i].flagVisited = false;
                }
            }
        }
    }
    
    public ArrayList<Edge> prim(){
        // buat variable arraylist primEdge
        ArrayList primEdge = new ArrayList();
        // buat variable arraylist integer primVertexs
        ArrayList<Integer> primVertexs = new ArrayList();
        // buat variable int seed = 0
//        int seed = 0;
        // add seed ke primVertex
        primVertexs.add(3);
        vertexList[3].flagVisited = true;
        
        while (primVertexs.size() < countVertex) {            
            int termMinWeight = Integer.MAX_VALUE;
            int tempMinIndekVertexI = -1;
            int tempMinIndekVertexJ = -1;
            
            for (int i = 0; i < primVertexs.size(); i++) {
                for (int j = 0; j < countVertex; j++) {
                    if (adjacencyMatrik[primVertexs.get(i)][j] > 0 && 
                            vertexList[j].flagVisited == false && 
                            adjacencyMatrik[primVertexs.get(i)][j] < termMinWeight) {
                        termMinWeight = adjacencyMatrik[primVertexs.get(i)][j];
                        tempMinIndekVertexI = i;
                        tempMinIndekVertexJ = j;
                    }
                }
            }
            primVertexs.add(tempMinIndekVertexJ); 
            vertexList[tempMinIndekVertexJ].flagVisited = true;
            primEdge.add(new Edge(tempMinIndekVertexI, tempMinIndekVertexJ, termMinWeight));
        }
        return primEdge;
    }
    
    public ArrayList<Edge> prim2(){
        ArrayList primEdge = new ArrayList();
        ArrayList<Integer> primVertex = new ArrayList<Integer>();
        int seed = 0;
        primVertex.add(seed);
        vertexList[seed].flagVisited = true;
        
        while (primVertex.size() < countVertex) {            
            int termMinWeight = Integer.MAX_VALUE;
            int tempMinIndekVertexI = -1;
            int tempMinIndekVertexJ = -1;
            
            for (int i = 0; i < primVertex.size(); i++) {
                for (int j = 0; j < countVertex; j++) {
                    if (adjacencyMatrik[primVertex.get(i)][j] > 0 &&
                            vertexList[j].flagVisited == false &&
                            adjacencyMatrik[primVertex.get(i)][j] < termMinWeight) {
                        termMinWeight = adjacencyMatrik[primVertex.get(i)][j];
                        tempMinIndekVertexI = i;
                        tempMinIndekVertexJ = j;
                    }
                }
                
            }
            primVertex.add(tempMinIndekVertexJ); 
            vertexList[tempMinIndekVertexJ].flagVisited = true;
            primEdge.add(new Edge(tempMinIndekVertexI, tempMinIndekVertexJ, termMinWeight));
        }
        return primEdge;
    }
}
