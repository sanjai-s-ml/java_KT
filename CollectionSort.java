import java.util.*;
public class CollectionSort {
    public static void main(String[] args) {
        List<Student> li=new ArrayList<>();
        li.add(new Student("sanjai",80));
        li.add(new Student("satvik",82));
        li.add(new Student("divith",89));
        li.add(new Student("bala",90));
        li.add(new Student("lalith",88));
        Collections.sort(li,(Student s1,Student s2) -> {return s2.mark - s1.mark;});
        li.forEach((Student s1)-> {
            System.out.println(s1.name+" "+s1.mark);
        });
    }
}

class Student{
    String name;
    int mark;
    Student(String name,int marks){
        this.name=name;
        this.mark=marks;
    }

}
