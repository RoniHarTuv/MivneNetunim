//ID: 207199282_322530080
public class Ex1 {
    /**
     * This function searches for a range of k in a sorted array by binary search.
     * 2 helper functions:
     * 1."binarySearchFirst": finds the first index in the array in which k appears by binary search.
     * 2."binarySearchLast": finds the last index where k appears by binary search.
     * @param arr- a sorted array
     * @param k- the value we're looking for
     * @return String of a range
     */

    public static String rangeOfK (int[] arr, int k){
        if(arr==null || arr.length==0){ return "[-1,-1]";}
        int start= binarySearchFirst(arr,k); // the first index where k appears
        int finish= binarySearchLast(arr,k);//the last index where k appears
        return "["+start+","+finish+"]";// the range
    }

    private static int binarySearchFirst(int[]arr, int k){
        int low= 0;
        int high= arr.length-1;
        while(low<=high){
            int middle= (low+ (high-low)/2); // the middle of the array
            int value= arr[middle]; //value= the number in the middle place in the array
            if(value<k) {
                low = middle + 1;// k is higher than value
            }
            if (value>k) {
                high=middle-1; //k is smaller than value
            }
            if(value==k){
                if (middle>0 && arr[middle-1]==k ){//check if the number before the found k is also k
                    high=middle-1;
                }
                else return middle;
            }
        }
        return -1;
    }
    private static int binarySearchLast(int[]arr, int k){
        int low= 0;
        int high= arr.length-1;
        while(low<=high){
            int middle= (low+ (high-low)/2); // the middle of the array
            int value= arr[middle]; //value= the number in the middle place in the array
            if(value<k) {
                low = middle + 1; // k is higher than value
            }
            if (value>k) {
                high=middle-1; //k is smaller than value
            }
            if(value==k){
                if (middle<arr.length-1 && arr[middle+1]==k ){//check if the number after the found k is also k
                    low=middle+1;
                }
                else return middle;
            }
        }
        return -1;
    }

//check:
    public static void main(String[] args) {
        int[] arr= {1,1,1,2,2,3,3,3,3,3,3,4,5,7,8,10,10,10};
        int ans= binarySearchFirst(arr,9);
        System.out.println(ans);
        int ans1= binarySearchLast(arr,2);
        System.out.println(ans1);
        String range= rangeOfK(arr,8);
        System.out.println(range);
        int[] a = {1,1,1,1,1,1,1,1,1};
        int[] b = {3};
        int[] c = {};
        int[] d = null;
        System.out.println(rangeOfK(a,2));
        System.out.println(rangeOfK(a,1));
        System.out.println(rangeOfK(b,1));
        System.out.println(rangeOfK(b,3));
        System.out.println(rangeOfK(c,1));
        System.out.println(rangeOfK(d,3));
        System.out.println(rangeOfK(d,2));
    }

}
