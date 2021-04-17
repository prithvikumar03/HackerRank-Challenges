package geekforgeeks;

public class MaxIndex {

    static int maxIndexDiff(int arr[], int n) {

        // Your code here
        int maxIndex = 0;
        int smallestNumForMaxIndex = arr[0];
        for(int i=0;i<n;i++){
            if((n-i)<maxIndex){
                break;
            }
            if(arr[i]>smallestNumForMaxIndex){
                continue;
            }
            int end_index = i;
            for(int j=i+1; j< n; j++){

                if(arr[j] >= arr[i]){
                    end_index = j;
                }
            }
            int diffIndex = end_index - i;
            if(diffIndex > maxIndex){
                smallestNumForMaxIndex = arr[i];
                maxIndex = Math.max(diffIndex, maxIndex);
            }

        }

        return maxIndex;
    }

    public static void main(String[] args) {
        int[] A = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int maxIndexDiff = maxIndexDiff(A, 9);
        System.out.println(maxIndexDiff);
        int[] B = {1, 10};
        maxIndexDiff = maxIndexDiff(B, 2);
        System.out.println(maxIndexDiff);

        int[] C = {82 ,63 ,44 ,74 ,82 ,99 ,82};
        maxIndexDiff = maxIndexDiff(C, 7);
        System.out.println(maxIndexDiff);

    }
}
