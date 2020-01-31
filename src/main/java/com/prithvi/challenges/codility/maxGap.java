package codility;

public class maxGap {

    public int solution(int N) {
        // write your code in Java SE 8
        int temp = N;
        int maxGap = 0;
        //Set this to -1 initially, in case there are no binary gaps, e.g. 32 will give a gap of 5 when there is no gap.
        int counter = -1;
        while(temp>0){
            //Get the binary digit
            int remainder = temp%2;
            //If its a 1, then check if the counter is greater than maxGap and reset the counter
            if(remainder==1){
                if(counter>maxGap)
                    maxGap=counter;
                counter=0;
            }
            else{
                if(counter>=0)
                    counter++;
            }
            //keep reducing
            temp=temp/2;
        }
        return maxGap;
    }

    public static void main(String[] args){
        int input = 4562123;
        int solution = new maxGap().solution(input);
        System.out.println(solution);
    }
}
