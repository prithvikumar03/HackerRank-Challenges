package geekforgeeks;

import java.util.stream.Collectors;

public class MagicalString {
    static String magicalString(String S){
        // code here
        StringBuilder builder = new StringBuilder();
        S.chars().map(x -> (char) (121 - x + 1)).forEach(builder::append);
        System.out.println(builder.toString());
        return builder.toString();
    }

    public static void main(String[] args) {
        magicalString("varun");
    }
}
