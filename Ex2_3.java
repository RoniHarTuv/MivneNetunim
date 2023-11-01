import java.util.Stack;

//207199282_322530080
public class Ex2_3 {
    /**
     * this class will represent a Queue that is defined by two stacks:
     */
    static class Queue2Stacks {
        Stack<Integer> stack1 ,stack2;
        int size;
        public Queue2Stacks(){ // constructor:
            this.stack1= new Stack<Integer>();
            this.stack2= new Stack<Integer>();
            this.size=0;
        }
        //Function to enqueue an item to the queue // O(1):
        public void enQueue (int x) {
            this.stack1.add(x);
            this.size++; // increase the size by one
        }
        //Function to dequeue an item to the queue // O(n):
        public int deQueue(){
            if(this.stack1.size()==0){ // if the stack is empty-return 0;
                return 0;
            }
            else {
                while (this.stack1.size() > 0) { //O(n)
                    this.stack2.add(this.stack1.pop());// moves all the integers from stack 1 to stack 2
                }
                int ans = this.stack2.pop(); //O(1)
                while (this.stack2.size() > 0) { //O(n)
                    this.stack1.add(this.stack2.pop()); //returns all the integers from stack 2 to stack 1
                }
                this.size--; //decrease the size by one
                return ans; // in general O(2n+1) = O(n) as asked.
            }
        }
        //Function returns true if the queue is empty,
        //otherwise it returns false.
        public  boolean isEmpty(){
            return this.size == 0;
        }
        //Function returns the number of items, sorted in the queue:
        public int size(){
            return this.size;
        }
    }

    public static void main(String[] args) {
        // tests deQueue and enQueue
       Queue2Stacks q = new Queue2Stacks();
       q.enQueue(1);
       q.enQueue(2);
       q.enQueue(3);
        System.out.println(q.deQueue());
        q.enQueue(4);
        while (q.size()>0){
            System.out.print(q.deQueue()+" , ");
            System.out.print(q.deQueue()+" , ");
            System.out.println(q.deQueue()+ " , ");
        }

        //tests size and isEmpty
        Queue2Stacks q2 = new Queue2Stacks();
        for (int i = 0; i <6 ; i++) {
            q2.enQueue(1);
        }
        System.out.println(q2.size);
        System.out.println(q2.isEmpty());
        while (q2.size>0){
            q2.deQueue();
        }
        System.out.println(q2.isEmpty());
         Queue2Stacks q3= new Queue2Stacks();
        System.out.println(q3.size);
        System.out.println(q3.deQueue());
    }
}
