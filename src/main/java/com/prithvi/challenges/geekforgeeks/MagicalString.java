package geekforgeeks;

import org.w3c.dom.ls.LSOutput;

import java.util.stream.Collectors;

public class MagicalString {
    static String magicalString(String S) {
        // code here
        //System.out.println(s);
        return S.chars().map(x -> {
                    if (x < 95)
                        return (char) ('A' + ('Z' - x));
                    else
                        return (char) ('a' + ('z' - x));

                }
        )
        .collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    }

    public static void main(String[] args) {
        String magicalString = magicalString("Hello");
        System.out.println(magicalString);
    }
}
