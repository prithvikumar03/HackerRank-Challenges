package stringproblems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCount {

    public static long getWordCount(String[] stringArray, String word){
        return Arrays.stream(stringArray)
                .map(String::toLowerCase)
                .filter(s -> s.equals(word.toLowerCase()))
                .count();
    }

    public static void printWordCount(String[] stringArray){
        List<String> uniqueItems = Arrays.stream(stringArray)
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());
        for(String s: uniqueItems){
            System.out.println(s + "-" + getWordCount(stringArray, s));
        }
    }

    public static void main(String[] args) {
        String[] stringArray = new String[]{"hello", "world", "HELLO", "WORLD"};
        printWordCount(stringArray);
    }
}
