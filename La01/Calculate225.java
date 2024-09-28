import java.util.Scanner;

public class Calculate225 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double num1 = keyboard.nextDouble();
        double num2 = keyboard.nextDouble();

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        String qoutient1 = (num2 != 0) ? String.valueOf(num1 / num2) : "Khongchiaduoc";
        double qoutient = Double.parseDouble(qoutient1);

        System.out.println(sum);
        System.out.println(difference);
        System.out.println(product);
        System.out.println(qoutient);
    }
}
