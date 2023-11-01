import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {
    public static int binarySearch(int arr[], int value){
        if (arr.length==0){
            return -1;
        }
        int min=0;
        int max= arr.length-1;
        while (min<=max){
            int middle= (min+max) /2;
            if (arr[middle]==value){
                return middle;
            }
            if (arr[middle]>value){
                max= middle-1;
            }
            if (arr[middle]<value){
                min=middle+1;
            }
        }
        return -1;
    }
    public static void Game(){
        System.out.println("welcome myFriend! please choose number from 0 to 1000 .");
        System.out.println("if your number is grater -press 3,if smaller-press 1. if i guess-press 2");
        Scanner in = new Scanner(System.in);
        int min= 0;
        int max=1000;
        while (min<=max){
            int mid= (max+min)/2;
            System.out.println("the number is "+ mid +"?");
            int input=in.nextInt();
            if (input==2){
                System.out.println("yayyy! your number is "+ mid);
                break;
            }
            if (input==1){
                max=mid-1;
            }
            if (input==3){
                min=mid+1;
            }
        }
    }
    public static boolean q4 (int[] arr){//o(n)
        boolean ans= false;
        if(arr.length==1){
            return ans;
        }
        int max= arr.length-1;
        int min= 0;
        while (min<max){
            if (arr[min]+arr[max]==0){
                return true;
            }
            if(arr[min]+arr[max]>0){
                max= max-1;
            }
            if(arr[min]+arr[max]<0){
                min=min+1;
            }
        }
        return ans;
    }
    public static boolean q5(int[] arr){ //o(n)
        boolean ans= false;
        if (arr.length==1){
            return true;
        }
        int min=0;
        int max= arr.length-1;
        int mid=(max-min)/2;
        while (mid<=max){
            if(arr[min]==arr[mid]){
                return true;
            }
            else{
                mid=mid+1;
                min= min+1;
            }
        }
        return ans;
    }
    public static boolean isValueEqualToIndex (int[]arr){// o(logn) //q2
        if(arr== null){
            return false;
        }
        int mid= (arr.length-1) /2;
        while(mid<arr.length-1){
            if (arr[mid]<=mid){
                return true;
            }
            mid= (arr.length+mid)/2;
        }
        return false;
    }
    //q5
    public static int[] commonAndSort (int[] a, int[] b){ // o(n log n)
        ArrayList <Integer> ans= new ArrayList<>();
        MergeSort.mergeSort(a);/// sort a and b
        MergeSort.mergeSort(b);

        for (int i = 0; i < a.length; i++) {
            if(binarySearch(b,a[i]) != -1){
                ans.add(a[i]);
        }
        }
        int[] ans1= new int[ans.size()];
        for (int j = 0; j < ans.size(); j++) {
            ans1[j]=ans.get(j);
        }
        return  ans1;
    }
    public static void countingSort(int[] arr){
        int max=arr[0];
        int min= arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                max=arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<min){
                min=arr[i];
            }
        }
        int size= (max-min)+1;
        int[] temp= new int[size];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]-min]++;
        }//סדרת סכומים
        for (int i = 1; i < temp.length ; i++) {
            temp[i]+=temp[i-1];
        }
        int[]arrTemp= new int[arr.length];
        for (int i = arr.length-1; i >= 0 ; i--) {
            int s= arr[i];
            int p= temp[s-min]-1;
            arrTemp[p] =s;
            temp[s-min]--;
        }
        System.arraycopy(arrTemp,0,arr,0,arr.length);
    }




    public static void main(String[] args) {
        //Game();
        int[] arr={-5,-4,-3,-2,-1,0,7,8,9,10};
        //System.out.println(q4(arr));
        int[] arr1={1,1,1,1,1,1,1,1,1,2,2,2,2,2};
        System.out.println(q5(arr1));
        int[] arr2= {1,1,1,1,1,4,5,9};
       // System.out.println(isValueEqualToIndex(arr2));
        int[] a= {1,2,3,4,5,6,7,8,9};
        int[]b= {2,4,6,9,10,11};
        int[]c= commonAndSort(a,b);
        System.out.println(Arrays.toString(c));
        int[] arr4= {1,2,3,4,5,6,6,9,10};
        System.out.println(isValueEqualToIndex(arr4));
        int[] abs= {1,7,2,8,4,9,78,67,56,22,3,1,0};
        countingSort(abs);
        System.out.println(Arrays.toString(abs));

    }
}
