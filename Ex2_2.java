//207199282_322530080
import java.util.Arrays;
public class Ex2_2 {
    /**
     * this function merges a given array via 3 sub arrays as asked.
     * @param arr
     */
    public static void mergeSort3(int[] arr) {
        if (arr.length==0) { // will check return empty array if the array is empty
            return;
        }
        if (arr.length==1){ //if we have only one integer inside the array will return the array as it is.
            return;
        }
        if(arr.length==2){ //if the length of the array is 2 will only change the first and the second value if not sorted.
            if (arr[0]<=arr[1]){
                return;
            }
            else {
                int temp=arr[0];
                arr[0]=arr[1];
                arr[1]=temp;
            }
        }
        else {// if none of the conditions that are mentioned above are happening, will merge the array by 3 subs array of the given array.
            int triple = arr.length / 3;
            int[] left = Arrays.copyOfRange(arr, 0, triple); //will set and copy the left arr
            int[] middle = Arrays.copyOfRange(arr, triple, triple * 2); //will set and copy the middle arr.
            int[] right = Arrays.copyOfRange(arr, triple * 2, arr.length); //will set and copy the right arr
            mergeSort3(left); //will call recursively the mergesort function with left sub array.
            mergeSort3(middle); //will call recursively the mergesort function with middle sub array.
            mergeSort3(right); //will call recursively the mergesort function with right sub array.
            int[] arr1 = new int[left.length + middle.length]; //will determine a new "temp" array.
            merge(left, middle, arr1);//will call the merge function and merge between the left and the middle array. will set the sorted array as arr1.
            merge(arr1, right, arr); //will merge the temp sorted array with the right sub array.
        }
    }

    /**
     * this function is an helper function to mergeSort3- it merge the sorted arrays
     * @param leftArray
     * @param rightArray
     * @param array
     */

    private static void merge(int[] leftArray, int[] rightArray, int[] array) { //this function will work like a regular merge that we have seen in the class.
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, l = 0, r = 0; //indices

        //check the conditions for merging
        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
//Test:
    public static void main(String[] args) {
        //will test with regular numbers:
        int [] a ={72,4,3,6,5,2,8,6666,7,22,66,11,33,1,98};
        mergeSort3(a);
        System.out.println(Arrays.toString(a));
        //will test with 2 length array.
        int[] b= {3,2};
        mergeSort3(b);
        System.out.println(Arrays.toString(b));
        //will test with 2 length array with same numbers.
        int[] c= {3,3};
        mergeSort3(c);
        System.out.println(Arrays.toString(c));
        //will test with 1 length array.
        int[] d= {1};
        mergeSort3(d);
        System.out.println(Arrays.toString(d));
        //will test with series of same values.
        int[] e= {6,9,8,8,8,8,8};
        mergeSort3(e);
        System.out.println(Arrays.toString(e));
        //will test with an empty array.
        int[] f= {};
        mergeSort3(f);
        System.out.println(Arrays.toString(f));
        // the test that are given with the assignment.
        int[] data = {45, -2, -45, 78, 30, -42, 10, 19, 73, 93};
        mergeSort3(data);
        System.out.println("After 3 way merge sort: ");
        for (int y : data) System.out.print(y + " ");
        //test with random numbers.
        int [] h = new int[7];
        for (int i = 0; i <7; i++) {
           h[i]= (int) (Math.random() * 100);
        }
        mergeSort3(h);
        System.out.println();
        System.out.println(Arrays.toString(h));
    }
}

