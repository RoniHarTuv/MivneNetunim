import java.util.Hashtable;

public class hashTable {
private int size;




 }









 class Student{
     private int age;
     private int id;
     private String name;
     private Student next;
     public Student(int age, int id, String name) {
         this.age =age;
         this.id=id;
         this.name=name;
     }
     public Student(Student s){
         age=s.age;
         id=s.id;
         name=s.name;
     }
     public int getId(){
         return this.id;
     }
     public int getAge(){
         return  this.age;
     }
     public String getName(){
         return this.name;
     }

 }

