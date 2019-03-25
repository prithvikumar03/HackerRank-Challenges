package hr;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EqualStacks {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        /*Iterator<Integer> lH1 = Arrays.stream(h1).boxed().collect(Collectors.toList()).iterator();
        Iterator<Integer> lH2 = Arrays.stream(h2).boxed().collect(Collectors.toList()).iterator();
        Iterator<Integer> lH3 = Arrays.stream(h3).boxed().collect(Collectors.toList()).iterator();*/

        int iH1=0;
        int iH2=0;
        int iH3=0;

        int lenH1=h1.length;
        int lenH2=h2.length;
        int lenH3=h3.length;

        Integer h1_sum = 0;
        Integer h2_sum = 0;
        Integer h3_sum = 0;
        for(int i: h1){
            h1_sum+=i;
        }
        for(int i: h1){
            h2_sum+=i;
        }
        for(int i: h1){
            h3_sum+=i;
        }

        Integer min_val = 0;
        boolean broken = false;

        while(  !((h1_sum.intValue()==h2_sum.intValue())&& (h1_sum.intValue()==h3_sum.intValue()))     ){

            if(iH1>=lenH1 || iH2>=lenH2 || iH3>=lenH3){
                broken=true;
                break;
            }

            min_val=h1_sum<h2_sum?(h1_sum<h3_sum?h1_sum:h3_sum):(h2_sum<h3_sum?h2_sum:h3_sum);
            while(h1_sum>min_val){
                h1_sum -= h1[iH1];
                iH1++;
            }

            while(h2_sum>min_val){
                h2_sum -=h2[iH2];
                iH2++;
            }

            while(h3_sum>min_val){
                h3_sum -=h3[iH3];
                iH3++;
            }

            //h1_sum = lH1.stream().mapToInt(Integer::intValue).sum();
            //h2_sum = lH2.stream().mapToInt(Integer::intValue).sum();
            //h3_sum = lH3.stream().mapToInt(Integer::intValue).sum();
        }

        return broken?0:h1_sum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
