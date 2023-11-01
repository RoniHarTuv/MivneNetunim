import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class sheelot_hazara {
    //שאלה 5
    public static int sortByVal(int[] arr, int val){
        int[] ans= new int[arr.length];
        int start=0;
        int end= arr.length-1;
        for (int i=0; i<arr.length;i++){
            if (arr[i]>val){
                ans[start]=arr[i];
                start++;
            }
            if(arr[i]<val){
                ans[end]=arr[i];
                end--;
            }
        }
        System.out.println(Arrays.toString(ans));
        return start-1;
    }
    //שאלה 10
    public static int root(int n){
        double ans=Math.pow(n,0.33);
        return (int) ans;
    }
    //שאלה 5 בקובץ 2
    public static int[] sort01(int[] arr){
        int ans[]= new int[arr.length];
        int i=0;
        int j=arr.length-1;
        for (int k = 0; k < arr.length ; k++) {
            if (arr[k]==0){
                ans[i]=0;
                i++;
            }
            else if (arr[k]==1){
                ans[j]=1;
                j--;
            }

        }
        return ans;
    }
    //שאלה 4 בקובץ 2
    public static String removeDouble(String s){//o(n)
        if (s.length()==0){
            return s;
        }
        String[] split=s.split(" ");//o(n)
        ArrayList<String> array= new ArrayList<>();//o(1)
        for (int i = 0; i < split.length; i++) {//o(n)
            if(!array.contains(split[i])) {
                array.add(split[i]);
            }
        }
        String ans= "";//o(1)
        for (int i = 0; i < array.size(); i++) {//o(n)
            ans+= array.get(i);
            ans+=" ";
        }
        return ans;
    }
    //שאלה 6 קובץ 2
    public static int[] sort_012 (int[] arr){
        int[] ans= new int[arr.length];
        int i=0;
        int j=arr.length-1;
        for (int k = 0; k < arr.length; k++) {
            if (arr[k]==0){
                ans[i]=0;
                i++;
            }
            if (arr[k]==2){
                ans[j]=2;
                j--;
            }
        }
        for (int k=i ; k <=j ; k++) {
            ans[k]=1;
        }
        return  ans;
    }


    public static void main(String[] args) {
        int[] arr= {5,8,1,3,4,9,10,11,12};
        System.out.println(sortByVal(arr,7));
        int a=53;
        System.out.println(root(a));
        LinkedList<Integer> ans= new LinkedList<Integer>();
        int[] b={1,1,1,0,0,0,1,0,1,0,1,0,0,0};
        System.out.println(Arrays.toString(sort01(b)));
        String s="to be or not to be";
        System.out.println(removeDouble(s));
        String s1= "sara shara shir sameach shir sameach sara shara hello";
        System.out.println(removeDouble(s1));
        int[] s2={1,2,1,2,0,2,0,0,0,1,2,1};
        System.out.println(Arrays.toString(sort_012(s2)));



    }

}
