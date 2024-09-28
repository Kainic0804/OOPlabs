import java.util.Scanner;

public class Seconddegreequation226 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double a = keyboard.nextDouble();
        double b = keyboard.nextDouble();
        double c = keyboard.nextDouble();
        double x;

        if(a==0){
            x = -c/b;
            System.out.println("PT co 1 nghiem x = " + x);
        }
        else{
            double delta = b * b - 4 * a * c;
            if(delta < 0){
                System.out.println("PT vo nghiem");
            }
            if(delta == 0){
                x = -b / 2 * a;
                System.out.println("PT co 1 nghiem x = " + x);
            }
            if(delta > 0){
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("PT co 2 nghiem x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
        }
    }
}
