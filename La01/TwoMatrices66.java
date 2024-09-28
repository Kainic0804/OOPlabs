import java.util.Scanner;

public class TwoMatrices66 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int rows = keyboard.nextInt();
        int cols = keyboard.nextInt();

        //Khoi tao 2 ma tran va 1 ma tran tong
        int[][] matran1 = new int[rows][cols];
        int[][] matran2 = new int[rows][cols];
        int[][] matranTong = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matran1[i][j] = keyboard.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matran2[i][j] = keyboard.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matranTong[i][j] = matran1[i][j] + matran2[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matranTong[i][j] + " ");
            }
            System.out.println();
        }
    }
}
