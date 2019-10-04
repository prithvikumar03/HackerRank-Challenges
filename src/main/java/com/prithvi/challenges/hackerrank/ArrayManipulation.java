package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        //List<Long> retList=new ArrayList<>();

        /*for(int i=0;i<n;i++){
            //retList.add(0l);
            System.out.println(sumArray[i]);
        }*/


        long[] sumArray=new long[n];
        for(int i=0;i<queries.length;i++){
            int k = queries[i][2];
            //for(int j=queries[i][0]-1;j<queries[i][1];j++){
                sumArray[queries[i][0]-1]+=k;
                sumArray[queries[i][1]]-=k;
                //retList.set(j,retList.get(j)+k);
            //}
        }

        long max=0;
        long x=0;
        for(long l:sumArray){
            x=x+l;
            if(max<x){
                max=x;
            }
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


    /*List<Long> retList=new ArrayList<>();
        for(int i=0;i<n;i++){
        retList.add(0l);
        }

        for(int i=0;i<queries.length;i++){
        int k = queries[i][2];
        for(int j=queries[i][0]-1;j<queries[i][1];j++){
        retList.set(j,retList.get(j)+k);
        }
        }

        return Collections.max(retList);*/