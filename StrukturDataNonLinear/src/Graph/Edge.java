/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author Aureli Isaias
 */
public class Edge {
    private int vertexA;
    private int vertexB;
    private int weight;

    public Edge() {
    }

    public Edge(int vertexA, int vertexB, int weight) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.weight = weight;
    }

    public int getVertexA() {
        return vertexA;
    }

    public void setVertexA(int vertexA) {
        this.vertexA = vertexA;
    }

    public int getVertexB() {
        return vertexB;
    }

    public void setVertexB(int vertexB) {
        this.vertexB = vertexB;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public String toString(){
        return "(" + vertexA + ", " + vertexB + " weight = " + getWeight() + ")";
    }
}
