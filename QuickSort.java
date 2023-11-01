import java.util.Arrays;

public class QuickSort {
    //O(n log(n)) , not good if already sorted
    public static void main(String[] args) {
        int[] arr = {8, 6, 4, 2, 3, 5, 7, 9, 10, 11};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        boolean isSort= InsertionSort.isSorted(arr);
        System.out.println(isSort);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot= partition(arr,start,end);
        quickSort(arr,start,pivot-1);
        quickSort(arr,pivot+1,end);
    }
    public static int partition(int[] arr, int start, int end) {
        int pivot= arr[end]; //always start with the last number
        int i= start-1;
        for(int j=0;j<end;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        i++;
        swap(arr,i,end);
        return i;// the index of the pivot;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}

