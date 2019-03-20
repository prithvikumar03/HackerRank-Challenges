package hr;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CamelCase {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String regLwrCase = "(.*[a-z].*)";
        String regUprCase = "(.*[A-Z].*)";
        String regNumber = "(.*[0-9].*)";
        String regSpecial = "(.*[!@#$%^&*()\\-+].*)";

        int nonMatchCount=0;
        if(!password.matches(regLwrCase)){
            nonMatchCount++;
        }

        if(!password.matches(regUprCase)){
            nonMatchCount++;
        }

        if(!password.matches(regNumber)){
            nonMatchCount++;
        }

        if(!password.matches(regSpecial)){
            nonMatchCount++;
        }

        if( (n+nonMatchCount) <6){
            nonMatchCount+= 6-(n+nonMatchCount);
        }


        return nonMatchCount;

        /*Pattern oPat = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+])(?=\\S+$).{6,}$");
        Matcher abc1 = oPat.matcher(password);
        System.out.println(abc1.matches());
        System.out.println(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+])(?=\\S+$).{6,}$"));*/

    }


    // Complete the camelcase function below.
    static int camelcase(String s) {

        Integer wordCount =0;

        if(s!=null || !s.isEmpty()) {
            wordCount++;
            for (Character c : s.toCharArray()) {
                if(Character.isUpperCase(c)){
                    wordCount++;
                }
            }
        }

        return wordCount;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        minimumNumber(7,"AUzsnV");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();


    }
}