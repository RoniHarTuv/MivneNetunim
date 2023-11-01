//207199282_322530080
import java.util.Stack;
/**
 * this class will represent a Queue that is defined by two stacks:
 */
public class Queue2Stacks {
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
    public int deQueue(){ //TODO
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
