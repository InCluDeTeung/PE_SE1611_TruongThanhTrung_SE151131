/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class Menu extends ArrayList<String>{
    public Menu(){
        super();
    }
    public int getUserChoice(){
        int choice=0, i;
        System.out.println();
        for (i = 0; i < this.size(); i++) {
            System.out.println( (i+1)+"-"+this.get(i));
        }
        System.out.print("Select an option: 1.."+i+": ");
        Scanner sc = new Scanner(System.in);
        choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
    
}
