import java.util.Arrays;

public class MyHashTable {
    public Node[] hash_table;

    public MyHashTable(int size){
        this.hash_table=new Node[size];
    }
    public MyHashTable(MyHashTable ht){
        this.hash_table= ht.hash_table;
    }
    public void insert(int key, Student student){
       int place= key % this.hash_table.length;
       if(hash_table[place]==null){
           hash_table[place]=new Node(student,key);
       }
       Node current= hash_table[place];
       while(current._next!=null){
           current=current._next;
       }
       current._next= new Node(student,key);
    }
    public Student remove(int key){
        int place= key % this.hash_table.length;
        if (hash_table[place]._key==key){
            remove(key);
        }
        Node current = hash_table[place];
        while (current._next!= null){
            current=current._next;
        }
        Student s= current._student;
        remove(current._key);
        return s;
    }
    public String toString(){
        return Arrays.toString(this.hash_table);
    }
    static class Student{
        public String name;
        public Integer age;
        public Student(String name, int age){
            this.name=name;
            this.age=age;
        }
        public void setName(String name){
            this.name=name;
        }
    }
    static class Node{
        Student _student;
        Integer _key;
        Node _next;
        public Node(Student s,int k){
            this._key=k;
            this._student=s;
            this._next=null;
        }
        public Node remove(Node n){
            remove(n);
            return n;
        }
    }
}
