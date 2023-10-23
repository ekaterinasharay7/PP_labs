import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                arr[i][j] = in.nextInt();
            }
        }
        // расставить строки по возрастанию через компаратор
MatrixRowSumComparator comparator = new MatrixRowSumComparator();
        Arrays.sort(arr,comparator);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.print("\n");
        }

    }
}