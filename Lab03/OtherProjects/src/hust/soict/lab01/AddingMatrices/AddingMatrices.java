package hust.soict.lab01.AddingMatrices;

import java.util.Scanner;

public class AddingMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m,n;
        System.out.print("Enter number of rows: ");
        m = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        n = scanner.nextInt();
        int[][] matrix1 = new int[m][n];
        int[][] matrix2 = new int[m][n];
        
        System.out.println("Enter the first matrix:");
        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the second matrix:");
        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        int[][] res = new int[m][n];
        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                res[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("Sum of the above matrices: ");
        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.exit(0);
    }
}
