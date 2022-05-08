/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A.Graph;
import java.util.LinkedList;
/**
 *
 * @author ACER
 */
public class MyQueue<E> extends LinkedList<E> {
    public MyQueue(){
        super();
    } // thêm cuối hàng đợi 
    public void enqueue(E x){
        this.addLast(x);
    }
    public E dequeue(){
        return this.poll();
    }
    
}
