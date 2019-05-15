/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.LinkedList;

/**
 *
 * @author Aureli Isaias
 */
public class Queue<E> {
    private LinkedList<E> antrian;
    
    public Queue(){
        antrian = new LinkedList<E>();
    }
    
    public void add(E e){
        antrian.addLast(e);
    }
    
    public Object remove(){
        return antrian.removeFirst();
    }
    
    public boolean isEmpty(){
        return antrian.isEmpty();
    }
}
