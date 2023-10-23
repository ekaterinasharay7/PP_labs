import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in);
        System.out.println("Enter your text");
        List<String> text = new ArrayList();
        String str= new String();
        int dlina;
        while(true){
            String current = in.nextLine();
            if(current.isEmpty()) break;
            text.add(current);
        }
        int count=text.size();
        String repl_str1;
        String repl_str2;

        for(int i=0;i<count;i++) {
            str = text.get(i);
             repl_str1=str.replace("pa","po");
            repl_str2=repl_str1.replace("Pa","Po");

            System.out.println(repl_str2);
        }
    }
}