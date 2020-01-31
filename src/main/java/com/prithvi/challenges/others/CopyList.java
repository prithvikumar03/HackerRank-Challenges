package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CopyList {

    public static void main(String[] args){
        List<String> A = Arrays.asList("a","b","c","d","e");
        List<String> collect = A.stream().collect(Collectors.toList());

        collect.stream().forEach(a -> System.out.println(a));
    }
}
