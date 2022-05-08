/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import B.DLLStudent;
import Utils.Menu;

/**
 *
 * @author ACER
 */
public class test {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add("1.Create");
        menu.add("2.Count the number of students");
        menu.add("3.Sort by mark");
        menu.add("4.Print by class");
        menu.add("5.Quit");
        DLLStudent st = new DLLStudent();
        int userchoice;
        do {            
            userchoice = menu.getUserChoice();
            switch(userchoice){
                case 1:
                    st.add();
                    break;
                case 2:
                    st.numOfStudent();
                    break;
                case 3:
                    st.sortList();
                    st.print();
                    break;
                case 4:
                    st.printbyClass();
                    break;
                case 5:
                    System.out.println("THANKS FOR USING!");
                    break;
                default: System.out.println("Please input again");
            }
        } while (userchoice!=5);
    }
}
