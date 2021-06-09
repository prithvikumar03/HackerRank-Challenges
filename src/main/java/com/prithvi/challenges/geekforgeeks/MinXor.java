package geekforgeeks;

import java.util.Arrays;

public class MinXor {
    static int minxorpair(int N, int arr[]){
        // code here
        int minXor = 0;
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                int temp = arr[i]^arr[j];
                //System.out.println(temp);
                if((i==0 && j==1) || temp<minXor)
                    minXor = temp;
            }
        }
        return minXor;
    }

    static int minxorpairEfficient(int N, int arr[]){
        // code here
        Arrays.parallelSort(arr);
        int minXor = Integer.MAX_VALUE;
        int val = 0;
        for(int i=0; i<arr.length-1; i++){
                val = arr[i]^arr[i+1];
                //System.out.println(temp);
                minXor = Math.min(val, minXor);
        }
        return minXor;
    }

    public static void main(String[] args) {
        int N = 3;
        int[] arr = {9,5,3};
        System.out.println(minxorpairEfficient(N, arr));
    }

}
