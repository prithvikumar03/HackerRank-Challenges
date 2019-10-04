package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HourGlass {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        List<Integer> sumList = new ArrayList<>();
        Integer noOfRows = arr.length;
        Integer noOfColumns = arr[0].length;

        if(noOfRows<3 || noOfColumns<3)
            return 0;

        for(int i=0; i<noOfRows-2;i++) {
            for (int j = 0; j < noOfColumns - 2; j++) {
                Integer sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j + 1] + arr[i+2][j + 2];
                sumList.add(sum);
            }
        }
        return Collections.max(sumList);
        //sumList.stream().max( (s1,s2) -> Integer.compare(s1,s2).get());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
