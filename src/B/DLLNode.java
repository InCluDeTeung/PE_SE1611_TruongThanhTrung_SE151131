/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

/**
 *
 * @author ACER
 */
public class DLLNode <E> {
    protected E info;
    protected DLLNode <E> next;
    protected DLLNode <E> prev;

    public DLLNode() {
    }

    public DLLNode(E info, DLLNode<E> next, DLLNode<E> prev) {
        this.info = info;
        this.next = next;
        this.prev = prev;
    }
    
    //getter&setter
    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public DLLNode<E> getNext() {
        return next;
    }

    public void setNext(DLLNode<E> next) {
        this.next = next;
    }

    public DLLNode<E> getPrev() {
        return prev;
    }

    public void setPrev(DLLNode<E> prev) {
        this.prev = prev;
    }
    
}
