public class Box <T>{
    T value;
    void set(T value){
        this.value=value;
    }
    T get(){
        return this.value;
    }

    public static void main(String[] args) {
        Box b=new Box();
        b.set(10);
        System.out.println(b.get());
        Box b2=new Box();
        b2.set("SANJAI");
        System.out.println(b2.get());
        Person p1=new Person("Sanjai",21);
        Box b3=new Box();
        b3.set(p1);
        System.out.println(b3.get().toString());
    }
}

class Person{
    String name;
    int age;
    Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Name : "+ this.name+"\nAge "+ this.age;
    }
}
