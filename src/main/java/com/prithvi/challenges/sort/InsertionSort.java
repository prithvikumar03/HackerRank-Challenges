package sort;

/**
 * Pick element one by one and check with all the elements before it.
 * while comparing if its less then the picked element, then exchange it.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arrayToSort = {5,4,7,25,16,2,1};
        for(int i=0;i<=arrayToSort.length-1;i++){
            int current = arrayToSort[i];
            int j = i-1;
            while(j>=0 && current<arrayToSort[j]){
                swapArrayElements(arrayToSort,j,j+1);
                j--;
            }
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
