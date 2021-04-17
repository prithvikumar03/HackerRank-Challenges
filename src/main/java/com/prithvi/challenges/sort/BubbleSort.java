package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arrayToSort = {5,4,6,7,16,1,2,1};

        //ascending
       /* for(int i=0;i<=arrayToSort.length-2;i++){
            for(int j=0;j<=arrayToSort.length-2-i;j++){
                if(arrayToSort[j] > arrayToSort[j+1]){
                    swapArrayElements(arrayToSort,j,j+1);
                }
            }
            printArrayElements(arrayToSort);
        }*/

        //descending
        for(int i=0;i<=arrayToSort.length-2;i++){
            for(int j=0;j<=arrayToSort.length-2-i;j++){
                if(arrayToSort[j] < arrayToSort[j+1]){
                    swapArrayElements(arrayToSort,j,j+1);
                }
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
