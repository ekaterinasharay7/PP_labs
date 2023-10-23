import java.util.Scanner;
import java.text.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input x from segment [-1;+1)");
        double x = in.nextDouble();
        System.out.println("Input k");
        int k=in.nextInt();
        final double e=Math.pow(10,-(k*2));
        double buf=x*(-1);
        int n=1;
        double res1=buf;
        double res_buf;
        while(n>0){
            res_buf=res1;
            buf*=x;
            buf*=n;
            n++;
            buf/=n;
            res1+=buf;
            if(Math.abs(res1-res_buf)<e){
                break;
            }
        }
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(k);
        System.out.println("Your answer is: ");
        System.out.println(formatter.format(res1));
        System.out.println("Answer of the computer is:");
        System.out.println(formatter.format(Math.log(1-x)));






    }
    }
