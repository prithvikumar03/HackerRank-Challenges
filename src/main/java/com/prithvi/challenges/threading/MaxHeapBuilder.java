package threading;

public class MaxHeapBuilder {

    public static void heapify(int[] arr,int n,int i){
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if(l<n && arr[l] > arr[largest]){
            largest = l;
        }

        if(r<n && arr[r] > arr[largest]){
            largest = r;
        }

        if(largest!=i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void maxHeap(int[] arr){
        int i = (arr.length/2)-1;
        int n = arr.length;
        for(int j=i;j>=0;j--){
            heapify(arr,n,j);
        }
    }

    public static int[] sort(int[] heapifiedArray){
        int length = heapifiedArray.length;
        int[] sortedArray = new int[length];
        for(int i = length -1; i>0; i--){
            sortedArray[i] = heapifiedArray[0];
            swapArrayElements(heapifiedArray,0,i);
            //heapifiedArray = Arrays.copyOfRange(heapifiedArray, 0, i);
            //maxHeap(heapifiedArray);
            heapify(heapifiedArray,i,0);
        }
        printArrayElements(sortedArray);
        return sortedArray;
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

    public static void main(String[] args) {
        int[] testArray = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        maxHeap(testArray);
        int[] sortedArray = sort(testArray);
/*        for (int x: sortedArray
             ) {
            System.out.println(x);
        }*/
    }


}
