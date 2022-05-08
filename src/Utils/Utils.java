/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class Utils {
    private static Scanner sc = new Scanner(System.in);

    public static String getString(String msg) {
        String result = "";
        boolean check = true;
        do {
            System.out.print(msg);
            String tmp = sc.nextLine().trim().toUpperCase();
            if (!tmp.isEmpty()) {
                result = tmp;
                check = false;
            } else {
                System.err.println("Input wrong!!! Please input again");
            }
        } while (check);
        return result;
    }
    public static double getADouble(String Msg) {
        double n;
        while (true) {
            try {
                System.out.print(Msg);
                n = Double.parseDouble(sc.nextLine());
                if(n>10 || n <0){
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println("Input less than 10 or greater than 0");
            }
        }
    }
    public static int getInt(String Msg) {
        int n;
        while (true) {
            try {
                System.out.print(Msg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println("Input wrong!!! Please input again");
            }
        }
    }
}
