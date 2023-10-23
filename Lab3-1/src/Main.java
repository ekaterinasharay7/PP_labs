//Sharay Ekaterina - lab3-1
import java.util.Scanner;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int m = in.nextInt();
        boolean chet;
        boolean found_chet = false;
        boolean diagonal_negative = false;
        int sum = 0;

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        for (int j = 0; j < m; j++) {
            chet = true;
            for (int i = 0; i < n; i++) {
                if (Math.abs(arr[i][j]) % 2 == 1) {
                    chet = false;
                }
            }
            if (chet) {
                System.out.println("The number of column with all even elements is " + j);
                found_chet = true;
            }
        }
        if (!found_chet) {
            System.out.println("There is no columns with all even elements");
        }


        for (int j = 0; j < m; j++) {
            sum = 0;
            diagonal_negative = false;
            for (int i = 0; i < n; i++) {
                sum += arr[i][j];
                if (i == j && arr[i][j] < 0) {
                    diagonal_negative = true;
                }
            }
            if (diagonal_negative) {
                System.out.println("The number of column with negative element on diagonal is " + j);
                System.out.println("And sum of elements of this column is " + sum);
            }
        }
    }
}

