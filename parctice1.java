import java.util.ArrayList;
import java.util.Arrays;

public class parctice1 {
    public static int[] q2 (String[] arr) {
        int[] ans0 = {0};
        if (arr == null) {
            return ans0;
        }
        int[] ans1 = {1};
        if (arr.length == 1) {
            return ans1;
        }
        if (arr.length==2){
            if (arr[0].equals(arr[1])){
                return new int[]{2};
            }
            return new int[]{1,1};

        }
        ArrayList<Integer> ans = new ArrayList<>();
        int counter = 1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i].equals(arr[i + 1])) {
                counter++;
                if(i==arr.length-2){
                    ans.add(counter);
                }
            } else {
                ans.add(counter);
                counter = 1;
            }
        }
        int[] answer= new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i]= ans.get(i);
        }
        return answer;
    }
    public static int[] q4 (String[] arr) {
        int[] ans0 = {0};
        if (arr == null) {
            return ans0;
        }
        int[] ans1 = {1};
        if (arr.length == 1) {
            return ans1;
        }
        if (arr.length==2) {
            if (arr[0].equals(arr[1])) {
                return new int[]{2};
            }
            return new int[]{1, 1};
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int counter = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1+i; j < arr.length ; j++) {
                if (arr[i].equals(arr[j])){
                    counter++;
                }
            }
            ans.add(counter);
            counter=1;
        }
        int[] answer= new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i]= ans.get(i);
        }
        return answer;
    }


    public static String q5(int[] arr){
        if(arr==null ||arr.length==0){
            return "no array";
        }
        if(arr.length==1){
            return "a1="+arr[0]+", a2="+ arr[0];

        }
        int a1= arr[0];
        int a2= arr[1];
        int temp = Math.abs(arr[0]-arr[1]);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (Math.abs(arr[i]-arr[j])<temp){
                    temp=Math.abs(arr[i]-arr[j]);
                    a1=arr[i];
                    a2=arr[j];
                }
            }
        }
       return"a1="+a1+" , a2="+a2 ;
    }
    public static String q6(int[] arr){
        if(arr==null ||arr.length==0){
            return "no array";
        }
        if(arr.length==1){
            return "a1="+arr[0]+", a2="+ arr[0];

        }
        int a1= arr[0];
        int a2= arr[1];
        int temp = Math.abs(arr[0]-arr[1]);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (Math.abs(arr[i]-arr[j])>temp){
                    temp=Math.abs(arr[i]-arr[j]);
                    a1=arr[i];
                    a2=arr[j];
                }
            }
        }
        return"a1="+a1+" , a2="+a2 ;
    }
    public static void main(String[] args) {
        //q2
//        String[] a = {"be", "be", "not", "or", "to", "to", "to"};
//        int[] a1 = q2(a);
//        System.out.println(Arrays.toString(a1));
//        String[] b = {"be", "be", "be", "be","be", "be","be", "be",};
//        int[] b1 = q2(b);
//        System.out.println(Arrays.toString(b1));
//        String[] c = {"be","to"};
//        int[] c1 = q2(c);
//        System.out.println(Arrays.toString(c1));
        //q4
        String[] aa={"to", "be", "or", "not", "to","be"};
        System.out.println(Arrays.toString(q4(aa)));
        //q5 +q6
        int[] arr1={ 1,-7,11,4,-1};
        int[] arr2={ 29,78};
        int[] arr3={ 29,78,5,6,5};
        int[] arr4={};
        System.out.println( q6(arr1));
        System.out.println( q5(arr2));
        System.out.println( q6(arr3));
        System.out.println( q5(arr4));

    }



}
