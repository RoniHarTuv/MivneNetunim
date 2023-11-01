import java.util.Arrays;

/**
 * @author Roni Hartuv
 */
public class MyQueue {
    //fails:
    public int[] queue;
    public int front, tail, size;
    public int n;//the size of the queue
    //constructor:
    public MyQueue(int n){
        this.front=0;
        this.size=0;
        this.tail =0;
        this.queue= new int[n];
        this.n=n;
    }

    /**
     * this function return true if the data enter to the queue, and false if not
     */
    public boolean enqueue(int data){
        boolean ans= true;
        if(size==n){
            ans= false;
        }
        else{
            queue[tail]=data;
            size++;
            tail =(tail +1) %n;
        }
        return ans;
    }
    /**
     * this function return the number that was deleted from the queue
     */
    public int dequeue(){
        int ans;
        if(size==0){
            System.out.println("queue is empty");
            ans=-0;
        }
        else {
            ans = queue[front];
            queue[front]=0;
            front = (front + 1) % n;
            size--;

        }
        return ans;
    }

    /**
     * return the firs element in the queue
     */
    public int peek(){
        int ans;
        if(size==0){
            ans= -0;
            System.out.println("queue is empty");
        }
        else{
            ans= queue[front];
        }
        return ans;
    }
    /**
     * return the sie of the queue
     */
    public  int size(){
        return this. size;
    }
    /**
     * return true if the queue is empty
     */
    public boolean isEmpty(){
        return size==0;
    }
    /**
     * clear the queue
     */
    public void clear(){
        size=0;
        front=0;
        tail=0;
    }
    /**
     * complexity: o(n) in the worst case
     * return true if the queue contains a given int
     */
    public boolean contains(int data){
        if(size==0){
            return  false;
        }
        else{
            for (int i = 0; i < queue.length; i++) {
                if (queue[i]==data){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * to string function
     * @param
     */
    public String toString(){
        return Arrays.toString(queue);
    }

    public static void main(String[] args) {
        MyQueue q1= new MyQueue(8);
        q1.enqueue(2);
        q1.enqueue(4);
        q1.enqueue(6);
        q1.enqueue(8);
        System.out.println(q1.toString());
        System.out.println("is contain 2? "+q1.contains(2));
        System.out.println("dequeue");
        q1.dequeue();
        System.out.println("is contain 2? "+q1.contains(2));
        System.out.println("size: "+q1.size());
        System.out.println("is empty? "+ q1.isEmpty());
        System.out.println("clear");
        q1.clear();
        System.out.println("is clear? "+ q1.isEmpty());
        q1.enqueue(6);
        q1.enqueue(7);
        System.out.println("add 6");
        System.out.println("add 7");
        System.out.println("peek="+ q1.peek());
        q1.enqueue(2);
        q1.enqueue(99);
        q1.enqueue(34);
        q1.enqueue(23);
        q1.enqueue(78);
        q1.enqueue(21);
        q1.enqueue(11);
        q1.enqueue(48);
        q1.dequeue();
        System.out.println("dequeue");
        q1.enqueue(100);
        System.out.println(q1.toString());
    }


}
