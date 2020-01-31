package others;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.OptionalInt;

public class Seasons {

    public String solution(int[] T) {
        // write your code in Java SE 8
        int length = T.length;
        int seasonLength = length / 4;
        int maxAmplitude = -99999;
        String maxAmpSeason = "WINTER";
        for(int i=0;i<4;i++) {
            //int[] season = Arrays.copyOfRange(T, i * seasonLength, (i * seasonLength) + seasonLength);
            OptionalInt max = Arrays.stream(T).skip(i * seasonLength).limit(seasonLength).max();
            OptionalInt min = Arrays.stream(T).skip(i * seasonLength).limit(seasonLength).min();
            if(max.isPresent() && min.isPresent()){
                int amp = max.getAsInt() - min.getAsInt();
                if(amp>maxAmplitude){
                    maxAmplitude=amp;
                    switch(i){
                        case 0:
                            maxAmpSeason="WINTER";
                            break;
                        case 1:
                            maxAmpSeason="SPRING";
                            break;
                        case 2:
                            maxAmpSeason="SUMMER";
                            break;
                        case 3:
                            maxAmpSeason="AUTUMN";
                            break;
                    }
                }
            }
        }

        return maxAmpSeason;
    }



    public static void main(String[] args){
        int[] input = {2,-3,3,1,10,8,2,5,13,-5,3,-18};
        String solution = new Seasons().solution(input);
        System.out.println(solution);
    }
}
