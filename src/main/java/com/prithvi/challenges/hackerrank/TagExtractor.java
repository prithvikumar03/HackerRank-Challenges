package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TagExtractor{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();
            extractor(line);
            //Write your code here
            final Pattern pattern = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher matcher = pattern.matcher(line);
            boolean found = false;

            while(matcher.find()){
                System.out.println(matcher.group(2));
                found = true;
            }

            if(!found){
                System.out.println("None");
            }
            testCases--;
        }

    }

    public static String extractor(String line){
        line.indexOf("<");
        System.out.println(line.indexOf("<"));
        return "";
    }
}