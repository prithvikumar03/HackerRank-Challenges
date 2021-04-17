package sort;

/**
 * //Find the min element from i'th position to the end of the array and exchange it with the i'th position
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arrayToSort = {5,4,7,25,16,2,1};
        for(int i=0;i<=arrayToSort.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<=arrayToSort.length-1;j++){
                if(arrayToSort[j]<arrayToSort[j-1]){
                    minIndex = j;
                }
            }
            swapArrayElements(arrayToSort,minIndex,i);
            printArrayElements(arrayToSort);
        }
    }

    public static void swapArrayElements(int[] array,int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void printArrayElements(int[] array){
        for(int element: array){
            System.out.print(element + ":");
        }
        System.out.println();
    }
}
