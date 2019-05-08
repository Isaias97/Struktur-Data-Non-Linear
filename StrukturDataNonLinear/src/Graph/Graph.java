/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.Stack;

/**
 *
 * @author Aureli Isaias
 */
public class Graph {
    int maxVertex = 10;
    char [] vertexList;
    int [][] adjacencyMatrik;
    int countVertex = 0;

    public Graph() {
        vertexList = new char[maxVertex];
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
        vertexList[countVertex++] = node; 
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
            if (vertexList[i] == index) {
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
}
