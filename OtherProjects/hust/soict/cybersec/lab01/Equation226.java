package hust.soict.cybersec.lab01;

import java.util.Scanner;

public class Equation226 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double a = keyboard.nextDouble();
        double b = keyboard.nextDouble();
        //Linear equation with one variable
        if(a != 0){
           double x = - b / a;
           System.out.println("Linear equation with one variable x = " + x);
        }
        else{System.out.println("Error");}
    }
}
