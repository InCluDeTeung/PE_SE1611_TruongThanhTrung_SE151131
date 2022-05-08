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
public class DLL<E> {
    protected DLLNode<E> head;
    protected DLLNode<E> tails;

    public DLLNode<E> getHead() {
        return head;
    }

    public void setHead(DLLNode<E> head) {
        this.head = head;
    }

    public DLLNode<E> getTails() {
        return tails;
    }

    public void setTails(DLLNode<E> tails) {
        this.tails = tails;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void addToHead(E value){
        if(this.head==null){
            this.head= new DLLNode<E>();
            this.head.setInfo(value);
            this.tails=this.head;
            
        }else{
            DLLNode<E> newNode = new DLLNode<E>();
            newNode.setInfo(value);
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            this.head=newNode;
        }
    }
    
    public void addToTail(E value){
        if(this.head==null){
            this.head= new DLLNode<E>();
            this.head.setInfo(value);
            this.tails=this.head;
            
        }else{
            DLLNode<E> newNode = new DLLNode<E>();
            newNode.setInfo(value);
            newNode.setPrev(this.tails);
            this.tails.setNext(newNode);
            this.tails=newNode;
        }
    }
    
    public void delete(E value){
        if(this.head!=null){
            DLLNode<E> currentNode = this.head;
            DLLNode<E> previousNode = this.head;
            while(currentNode != null){
                if(currentNode.getInfo()==value){
                    previousNode.setNext(currentNode.getNext());
                    if(currentNode.getNext() != null){
                        currentNode.getNext().setPrev(previousNode);
                    }
                    System.out.println("Delete first node with value" +value);
                    break;
                }else{
                    previousNode=currentNode;
                    currentNode=currentNode.getNext();
                }
            }
        }
    }
    
    public void printAll(){
        if(head==null){
            System.out.println("Double linked list is empty.");
            return;
        }
        DLLNode<E> now = head;
        while(now !=null){
            System.out.println(now.info);
            now=now.getNext();
        }
    }
    
    public void printAlls() {
        for (DLLNode<E> tmp = head; tmp != null; tmp = tmp.next)
            System.out.println(tmp.info);
    }
}
