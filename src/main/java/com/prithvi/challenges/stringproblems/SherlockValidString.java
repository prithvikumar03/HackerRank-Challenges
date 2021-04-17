package stringproblems;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockValidString {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the isValid function below.
    static String isValid(String s) {
        int[] listInteger = new int[26];

        s.chars().forEach(x -> {
            int y=x-97;
            listInteger[y]+=1;
        });


        int max = Arrays.stream(listInteger).filter(x -> x > 0).max().getAsInt();
        int[] ints = Arrays.stream(listInteger).filter(x -> x > 0).toArray();
        int numofDiffIs1 = 0;
        int numOfMax = 0;
        int numOfOnes = 0;
        int numOfDiffGtThan1 = 0;
        for (int anInt : ints) {
            if (Math.abs(max - anInt) == 0) {
                numOfMax++;
            } else if ((max - anInt > 1)) {
                numOfDiffGtThan1++;
                if(numOfDiffGtThan1>1 || numofDiffIs1>0)
                    return "NO";
            }
            else if ((max - anInt == 1)) {
                numofDiffIs1++;
                if(numOfDiffGtThan1>0)
                    return "NO";
            }
            if (anInt == 1) {
                numOfOnes++;
            }
        }


        /*if(numofDiffIs1>0 && numOfDiffGtThan1>0)
            return "NO";*/
        //All are the same number or there is only one number which is one more than the rest (other conditions taken care in the loop)
        if(numOfMax==ints.length || numOfMax==1)
            return "YES";
        if(numOfMax==ints.length-1 && numOfOnes==1)
            return "YES";

        return "NO";
    }

    public static void main(String[] args) throws IOException {


        //System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
        System.out.println(isValid("xxxaabbccrry"));
        //System.out.println(isValid("aabbccddeefghi"));

        /*int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = isValid(s);
            System.out.println(result);

        }
        scanner.close();*/
    }

}
