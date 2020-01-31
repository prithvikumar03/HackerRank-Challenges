package others;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Winter {

    public int solution(int[] T) {
        // write your code in Java SE 8
        int partitionIndex = 999999;

        List<Integer> collect = IntStream.range(0, T.length - 1)
                .filter(i -> T[i] < T[i + 1])
                .mapToObj(i -> i+1)
                .collect(Collectors.toList());

        int prev_i=0;
        int prev_max=0;
        for(int i: collect){
            //int[] subArray = Arrays.copyOfRange(T, prev_i, i);
            //prev_i=i;
            OptionalInt max = Arrays.stream(T).skip(0).limit(i).max();
            OptionalInt min = Arrays.stream(T).skip(i+1).min();
            //OptionalInt max = Arrays.stream(subArray).max();
            if(max.isPresent() && min.isPresent()){
                if(max.getAsInt()<T[i] && min.getAsInt()>=T[i]){
                    partitionIndex=i;
                    break;
                }
            }
            else if(!min.isPresent()){
                partitionIndex=i;
            }
        }

        return partitionIndex;
    }

    public static void main(String[] args){
        //{-1,5,3,4,7} {-5,-5,-5,-42,6,12}
        int[] input = {-1,5,-10,4,7,12,13,14,15};
        int solution = new Winter().solution(input);
        System.out.println(solution);
    }

}
