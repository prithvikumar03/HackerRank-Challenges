package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result1 {

    /*
     * Complete the 'kDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */

    public static int kDifference(List<Integer> arr, int k) {
        // Write your code here
        HashMap<Integer,Integer> opHash = new HashMap<>();



        System.out.println(k);
        int i=1;
        int count=0;
        for (Integer val:arr){
            try{
                List<Integer> integers = arr.subList(i,arr.size());

                for(Integer compareVal : integers){
                    if(Math.abs(val-compareVal)==k){
                        count++;
                    }
                }

                i++;
            }
            catch(Exception e){
                System.out.println("End of array reached");
            }
        }

        System.out.println(opHash.keySet());
        return opHash.keySet().size();


    }

}

public class KDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result1.kDifference(arr, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}



//System.out.println(integers);
                /*integers.stream().forEach(x -> {
                    if(Math.abs(x-val)==k){
                        opHash.put(val,x);
                    }
                });*/