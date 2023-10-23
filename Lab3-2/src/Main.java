//Sharay Ekaterina - lab3-2
import java.util.Scanner;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        int[] arr_result = new int[n+m-1];
        int min;
        int buf=0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                arr[i][j] = in.nextInt();
            }
        }
        for(int i=0;i<n+m-1;i++){
                arr_result[i]=0;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr_result[i+j]+=arr[i][j];

            }
        }
System.out.println("Sum of lines parallel of the main diagonal is: ");
for(int i=0;i<n+m-1;i++){
    System.out.println(arr_result[i]);
}

min=arr_result[0];
Arrays.sort(arr_result);
System.out.println("Min sum is "+ arr_result[0]);


    }
}