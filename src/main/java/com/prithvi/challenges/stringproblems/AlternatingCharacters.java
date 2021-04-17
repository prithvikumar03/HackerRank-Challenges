package stringproblems;

import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        int[] ints = s.chars().toArray();
        int prevChar = -1;
        int count = 0;
        for(int i=0;i<ints.length;i++){
            if(prevChar == ints[i]){
                count++;
            }
            prevChar = ints[i];
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);
            System.out.println(result);

        }
        scanner.close();
    }
}
