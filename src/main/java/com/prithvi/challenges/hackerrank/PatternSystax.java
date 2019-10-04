package hackerrank;

import java.util.Scanner;
import java.util.regex.*;

public class PatternSystax
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String pattern = in.nextLine();
            //Write your code
            try {
                Pattern objPattern = Pattern.compile(pattern);
                System.out.println("Valid");
            }
            catch(Exception e){
                System.out.println("Invalid");
            }

        }
    }
}
