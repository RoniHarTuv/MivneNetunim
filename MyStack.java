//207199282_322530080
import java.util.ArrayList;

public class MyStack<T>{

    private ArrayList<T> stack;
    private int size;
    private int MaxSize= 100;
    public MyStack (){
       this.stack=new ArrayList<>();
       this.size=0;
    }
    public boolean push( T t){
        if(this.size>=MaxSize){// />=100
            return false;
        }
        this.stack.add(t);
        return true;
    }
    public T pop(){
        if(this.size==0){
            return null;
        }
        size--;
        return this.stack.remove(size);
    }
    public T peek(){
        if(this.size==0){
            return null;
        }
        return this.stack.get(size-1);
    }
    public void clear(){
        this.stack.clear();
        this.size=0;
    }








}
