package hust.soict.lab01.DisplayTriangle;

import java.util.Scanner;

public class DisplayTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the height of the triangle: ");
        int n = scanner.nextInt();

        for (int i=1; i<=n;i++) {
            for (int j=1;j<=n-i;j++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
