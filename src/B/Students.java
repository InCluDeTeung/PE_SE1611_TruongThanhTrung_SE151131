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
public class Students {
    String name; 
    String classroom;
    double markAvg;

    public Students() {
    }

    public Students(String name, String classroom, double markAvg) {
        this.name = name;
        this.classroom = classroom;
        this.markAvg = markAvg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public double getMarkAvg() {
        return markAvg;
    }

    public void setMarkAvg(double markAvg) {
        this.markAvg = markAvg;
    }


    private String xepLoai(double markAvg){
        if(markAvg <5){
            return "Yếu";
        }else if(markAvg <=6){
            return "Trung Bình";
        }else if(markAvg <8){ 
            return "Khá";
        } else {
            return "Giỏi";
        }
    }

    @Override
    public String toString() {
        return "Students{" + "name=" + name + ", classroom=" + classroom + ", markAvg=" + markAvg + ", Xếp Loại: " + xepLoai(markAvg) +'}';
    }
    
    
}
