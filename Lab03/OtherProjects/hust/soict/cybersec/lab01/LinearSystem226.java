package hust.soict.cybersec.lab01;

import java.util.Scanner;

public class LinearSystem226 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double a11 = keyboard.nextDouble();
        double a12 = keyboard.nextDouble();
        double b1 = keyboard.nextDouble();
        double a21 = keyboard.nextDouble();
        double a22 = keyboard.nextDouble();
        double b2 = keyboard.nextDouble();

        double D = a11 * a22 - a12 * a21;
        if (D != 0) {
            double x1 = (b1 * a22 - b2 * a12) / D;
            double x2 = (a11 * b2 - a21 * b1) / D;
            System.out.println(x1);
            System.out.println(x2);
        }
        else{
            if (a11 * b2 != a21 * b1 || a12 * b2 != a22 * b1){
                System.out.println("Vo nghiem");
            }
            else{System.out.println("Vo so nghiem");}
        }
    }
}
