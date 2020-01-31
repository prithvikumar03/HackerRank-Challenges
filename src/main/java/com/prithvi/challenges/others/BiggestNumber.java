package others;

import java.util.Arrays;
import java.util.List;

public class BiggestNumber {

    //https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/

    static List<Integer> numList = Arrays.asList(1, 34, 3, 98, 9, 76, 45, 4);

    public static Integer myCompare(Integer int1, Integer int2){
        String s = int1.toString();
        String s1 = int2.toString();
        int i1 = Integer.parseInt(s + s1);
        int i = Integer.parseInt(s1 + s);
        return i1>i?1:i1==i?0:-1;
    }

    public static String genBiggestNumber(List<Integer> numList){
        String stringStream = numList.stream().sorted(BiggestNumber::myCompare).map(i -> Integer.toString(i))
                .reduce("" , (s1,s2)->s2+s1);
        return stringStream;
    }

    public static void main(String[] args){
        String s1 = genBiggestNumber(numList);
        System.out.println(s1);
    }
}
