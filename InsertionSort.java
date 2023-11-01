import java.util.Arrays;
public class InsertionSort { //סיבוכיות = O(n^2)/ מיון הכנסה

        public static void insertionSort2(int[]arr){
            for (int i= 1; i<arr.length; i++){ //רצים על המערך עם i
                int j=i-1; //ג'יי רץ מהאיבר האיי (הנבחר) עד לתחילת המערך וכל פעם משווה את האיבר הנוכחי עם טמפ
                int temp = arr[i];//טמפ הוא האיבר הנבחר במיקום האיי
                while ((j>=0)&& (arr[j]> temp)){// כל עוד ג'יי לא הגיע לתחילת המערך, ואם ג'יי גדול מטמפ-
                    arr[j+1]= arr[j];
                    j--;
                }
                arr[j+1]= temp;
            }
        }
        public static boolean isSorted(int[] arr){
            boolean ans = true;
            for (int i = 0; ans && i < arr.length-1; i++) {
                if (arr[i] > arr[i+1]) ans = false;
            }
            return ans;
        }
        public static void checkInsertiontionSort2(int[]arr){
            int[]a = Arrays.copyOf(arr, arr.length);
            long  timeBefore,timeAfter;
            timeBefore = System.currentTimeMillis();
            insertionSort2(a);
            timeAfter = System.currentTimeMillis();
            double elapse = (timeAfter-timeBefore)/1000.0;
            System.out.println("insertionSort2 time = " + elapse+" seconds, is sorted? "+isSorted(a));
        }
        public static void checkJavaSort(int []arr){
            int[]a = Arrays.copyOf(arr, arr.length);
            long  timeBefore,timeAfter;
            double elapse;
            timeBefore = System.currentTimeMillis();
            Arrays.sort(a);
            timeAfter = System.currentTimeMillis();
            elapse = (timeAfter-timeBefore)/1000.0;
            System.out.println("Java Sort time = " + elapse+" seconds, is sorted? "+isSorted(a));
        }
        public static void main(String[] args) {
            int size = 50000;
            System.out.println("size = "+size);
            int [] array = MyLibrary.randomIntegerArray(size);
            checkInsertiontionSort2(array);
            checkJavaSort(array);

        }
    }

