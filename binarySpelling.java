import java.util.ArrayList;
import java.util.Arrays;

public class binarySpelling {
    public static String binary (int a){
        String s="";
        while(a/2!=0 || a%2!=0){
            s += a%2;
            a=a/2;
        }
        String ans="";
        for (int i = s.length()-1; i >=0 ; i--) {
            ans+=s.charAt(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int a=19;
        String ans= binary(a);
        System.out.println(ans);
        int b= 236;
        System.out.println(binary(b));
        int c= 23505;
        System.out.println(binary(c));  //101101111010001
        int[] aa= {1,2,3,4,5,6,7,8,9};
        int[] bb= {1,3,10,11,12,13,14,15,16};
        int a1= binarySearch(0,aa);
        int a2=binarySearch(2,aa);
        System.out.println(a1);
        System.out.println(a2);
        ArrayList<Integer> aabb= ex5(aa,bb);
        System.out.println(aabb);
    }

    public static ArrayList<Integer> ex5(int[] a, int[] b){
        ArrayList<Integer> ans= new ArrayList<>();
        for (int i = 0; i <= a.length-1; i++) { //o(n)
            int c= binarySearch(a[i],b); //o(log n)
            if(c==1)
            {ans.add(a[i]);
            }
        }
        return ans;
    }
    public static int binarySearch (int a, int[] b){ //o(log n)
        if(b.length==1&& b[0]==a){
            return 1;
        }
        if(b.length==0){
            return -1;
        }
        int min= 0;
        int max= b.length-1;
        while (min<=max){
            int mid= (max+min)/2;
            if(b[mid]>a){
                max=mid-1;
            }
            else if (b[mid]<a){
                min=mid+1;
            }
            else {
                return 1;
            }

        }
        return -1;
    }

}
