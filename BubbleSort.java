import java.util.Arrays;

public class BubbleSort { //O(n^2)
    public static void bubbleSort (int[] arr){
        for(int i=0; i<arr.length-1; i++){
            for (int j=0; j< arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    swap (arr,j,j+1);
                }
            }
        }
        //hello
    }
    public static void swap (int[] arr, int i, int j){
        int temp= arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }
    public static void main(String[] args) {
        int[] Myarr={1,4,3,9,7,6,2,10,13};
        bubbleSort(Myarr);
        System.out.println(Arrays.toString(Myarr));
    }



}

