import java.util.Arrays;

public class MergeSort {
    // run time complexity= O(n log n)
    public static void mergeSort(int[] array) {
        if (array.length <= 1) return; //base case

        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle); //left array
        int[] right = Arrays.copyOfRange(array, middle, array.length); // right array

        mergeSort(left);
        mergeSort(right);
        merge(left, right, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {

        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, l = 0, r = 0; //indices

        //check the conditions for merging
        while(l < leftSize && r < rightSize) {
            if(leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
    //check:
    public static void main(String[] args) {
        int[] arr= {2,4,6,8,0,9,7,5,3};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2={7,7,8,6,1,2,3,4,0,11,26};
        mergeSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

}
