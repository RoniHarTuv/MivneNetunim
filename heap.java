public class heap {
    private int[] heap;

    public heap (int[] arr){
        heap= new int[arr.length];
        System.arraycopy(arr,0,heap,0,arr.length);
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private  int leftChild(int p){
        return (2*p)+1;
    }
    private  int rightChild(int p){
        return (2*p)+2;
    }
    private void minHeapify(int[] arr, int v, int heapSize) {//v האיבר שעושים עליו את הפונקציה.
        int left = leftChild(v);
        int right = rightChild(v);
        int small;
        if (left < heapSize && arr[left] < arr[v]) {
            small = left;
        }
        else {small = v;}
        if(right<heapSize&&arr[right]<arr[small]){
            small=right;
        }
        if(small!=v){
            swap(arr,v,small);
            minHeapify(arr,small,heapSize);
        }
    }
    public void buildMinHeap(int[] arr){
        for (int i=0; i<=(arr.length-2)/2;i++){
            minHeapify(arr,i,arr.length);
        }
    }
    public void heapSort(int[]arr){
        buildMinHeap(arr);
        int heapSize= arr.length;
        for (int i = heapSize-1; i >=1 ; i--) {
            swap(arr,0,arr.length-1);
            heapSize--;
            minHeapify(arr,0,heapSize);
        }
    }
    public int heapExtractMin(int[] arr,int heapSize){
        int ans= arr[0];
        arr[0]=arr[heapSize-1];
        heapSize--;
        minHeapify(arr,0,heapSize);
        return ans;
    }
    private void heapDecreaseKey(int[] arr,int i,int key){
        if(key<arr[i]){
            arr[i]=key;
            while (i>0 && arr[parent(i)] >arr[i]) {
                swap(arr, i, parent(i));
                i = parent(i);
            }
        }
    }
    public void minHeapInsert(int[]arr,int key,int heapSize){
        //arr size-resize- TODO
        heapSize++;
        arr[heapSize-1]= Integer.MIN_VALUE;
        heapDecreaseKey(arr,heapSize-1,key);
    }
    public void swap(int[] arr, int i , int j){
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }












}
