import java.util.*;
class User{
    private int id;
    private String name;
    User(int id,String name){
        this.id=id;
        this.name=name;
    }
    public int getId(){
        return this.id;
    }
     public void setId(int id){
        this.id=id;
     }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String toString(){
        return "Id : "+this.id +" Name : "+this.name;
    }
}
interface Repository<T>{
    void create(T item);
    T read(int id);
    void update(int id,T item);
    void delete(int id);

}
public class UserRepository implements Repository<User>{
    Map<Integer,User> map=new HashMap<>();
    public void create(User u){
        map.put(u.getId(),u);
    }
    public User read(int id){
        return map.get(id);
    }
    public void update(int id,User u){
        if(map.containsKey(id)){
            map.put(id,u);
        }
        else{
            System.out.println("USER not found");
        }
    }

    public void delete(int id){
        map.remove(id);
        System.out.println("Deleted successfully");
    }
    public List<User> getAll(){
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        UserRepository user=new UserRepository();
        user.create(new User(1,"Sanjai"));
        user.create(new User(2,"Satvik"));
        System.out.println(user.read(1));
        user.update(1,new User(1,"SANJAI"));
        System.out.println(user.read(1));
       // user.delete(2);
        System.out.println("Final Users "+ user.getAll());

    }
}
