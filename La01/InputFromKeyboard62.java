import java.util.Scanner;

public class InputFromKeyboard62 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("What's your name? : ");
        String strName = keyboard.nextLine();
        System.out.print("How old are you? : ");
        int iAge = keyboard.nextInt();
        System.out.print("How tall are you (m)? : ");
        double dHeight = keyboard.nextDouble();

        System.out.println("Mr/Mrs. " +strName + ", " + iAge + " years old. "
                + "Your height is " + dHeight + ".");
    }
}
