public class Recursion {
    public static int sum(int a, int b){
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        return sum(a,(b-1))+1;
    }
    public static int substruct(int a, int b){
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        return substruct(a,(b-1))-1;
    }
    public static int mul(int a, int b){
        if(a==1){
            return b;
        }
        if (b==1){
            return a;
        }
        return mul(a,(b-1)) +a;
    }
    public static int division(int a, int b){
        if(a<b) {
            return 0;
        }
        return division(a-b,b)+1;
    }
    public static int remainder(int a, int b){
        if(a<b){
            return a;
        }
        return remainder(a-b,b);
    }
    public static long power(int base, int pow){
        if(pow==0){
            return 1;
        }
        return power(base,pow-1)*base;
    }
    public static int powerTwo(int a){
        if(a==0){
            return 1;
        }
        return powerTwo(a-1)+powerTwo(a-1);
    }
    public static int reverse(int a){
        int ans=0;
        while(a!=0){
            ans= ans*10 + a%10;
            a=a/10;
        }
        return ans;
    }

    public static String reverseString(String s){
        String ans= "";
        if(s.length()==1 ){
            return s;
        }
        return s.charAt(s.length()-1) + reverseString(s.substring(0,s.length()-1));
    }
    public static long factorial(long n){
        if(n==0){
            return 1;
        }
        return factorial(n-1)*n;
    }
    public static long fibonachi (int index){
        if(index==0){
            return 1;
        }
        if (index==1){
            return 1;
        }
        return fibonachi(index-1)+fibonachi(index-2);
    }


    public static void main(String[] args) {
        int c= sum(2,800);
        System.out.println(c);
        int c1= substruct(100,10);
        System.out.println(c1);
        int c2= mul(4,5);
        System.out.println(c2);
        int c3=division(100,50);
        System.out.println(c3);
        int c4= remainder(21,5);
        System.out.println(c4);
        int c5= powerTwo(3);
        System.out.println(c5);
        System.out.println(reverse(12345));
        System.out.println(fibonachi(4));
        System.out.println(factorial(3));
        System.out.println(reverseString("roni"));
        System.out.println(power(2,8));
        }


}
