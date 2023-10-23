import java.util.Comparator;

public class MatrixRowSumComparator implements Comparator <int[]> {
    @Override
    public int compare(int[] row1, int[] row2){
        int sum1=calculateRowSum(row1);
        int sum2=calculateRowSum(row2);
        return Integer.compare(sum1,sum2);
    }
    private int calculateRowSum(int[] row){
        int sum=0;
        for(int element: row){
            sum+=element;
        }
        return sum;

    }
}
