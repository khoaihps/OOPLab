package hust.soict.lab01.Array;

import java.util.Arrays;
import java.util.Scanner;

public class WorkWithArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,sum=0;
        System.out.print("Enter number of elements in the array: ");
        n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i <= n - 1; i++) {
            System.out.print("Enter element a["+i+"]: ");
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);
        double averageValue = (double)((double)sum / n);

        System.out.println("Array elements in increasing order: " + Arrays.toString(arr));
        System.out.println("Sum of array elements             : " + sum);
        System.out.println("Average value of array elements   : " + averageValue);
        System.exit(0);
    }
}
