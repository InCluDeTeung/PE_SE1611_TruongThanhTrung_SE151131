/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import Utils.Utils;

/**
 *
 * @author ACER
 */
public class DLLStudent extends DLL {
    DLL<Students> dll = new DLL<>();
    public DLLStudent() {
        super();
    }
    
    private DLLNode<Students> finds(DLLNode<Students> tmp) {
        DLLNode<Students> ref;
        for (ref = dll.getHead(); ref != null; ref = ref.getNext())
            if (ref.getInfo().getClassroom().equals(tmp.getInfo().getClassroom()))
                return ref;
        return null;
    }
    
    public int find (String clas){
        DLLNode<Students> now = dll.getHead();
        int i=0;
        while(now!=null){
            if(now.getInfo().getClassroom().equalsIgnoreCase(clas)){
               i=i+1; 
            }
            now=now.getNext();
        }
        return i;
    }
    
    public Students data(){
        String name = Utils.getString("Input name : ");
        String classroom = Utils.getString("Input class: ");
        Double markAVG = Utils.getADouble("Input mark: ");
        return new Students(name, classroom, markAVG);
    }
    
    public void add() {
        int nStudent = Utils.getInt("Input N of student: ");
        for (int i = 0; i < nStudent; i++) {
            System.out.println("Add student"+ i+ "into list");
            Students tmp = data();
            dll.addToTail(tmp);     
            System.out.println("Add Success!");
        }
    } 
    
    public void numOfStudent(){
        String clas = Utils.getString("Enter class: ");
        int numOfStudent = find(clas);
        System.out.println("Class "+clas+" have "+numOfStudent+" student.");
    }
    
    public void sortList(){
        DLLNode<Students> current = dll.getHead();
        DLLNode<Students> index = null;
        Students tmp;
        if(current==null){
            return;
        }else{
            while (current != null) {                
                index=current.getNext();
                while (index !=null) {                    
                    if(current.getInfo().getMarkAvg()>index.getInfo().getMarkAvg()){
                       tmp = current.getInfo();
                       current.setInfo(index.getInfo());
                       index.setInfo(tmp);
                    }
                    index=index.getNext();
                }
                current=current.getNext();
            }
        }
    }
    
    public void print(){
        dll.printAll();
    }
    
    public void printbyClass(){
        for(DLLNode<Students> tmp = dll.getHead(); tmp != null; tmp = tmp.getNext()){
            DLLNode<Students> now = finds(tmp);
            if(now !=null){
            System.out.println(now.getInfo().toString());
            }
        }
    }
    
    //test
     public static void main(String[] args) {
        DLLStudent st = new DLLStudent();
        st.add();
        System.out.println("Class");
        st.printbyClass();
    }
     
}
