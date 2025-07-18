import java.util.*;
public class UniqueInteger {
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(18,200,18,20,20,30,45,58,69,58,26);
        System.out.println("Before Removing duplicates :");
        list.forEach((Integer num)-> System.out.println(num));
        list=removeDuplicates(list);
        System.out.println("After Removing duplicates :");
        list.forEach((Integer num)-> System.out.println(num));


    }
    public static  List removeDuplicates(List<Integer> list){
        Set<Integer> set=new HashSet<>();
        list.forEach((Integer num) -> set.add(num));
        Iterator it=set.iterator();
        List<Integer> newList=new ArrayList<>();
        while(it.hasNext()){
            newList.add((Integer) it.next());
        }
        return newList;
    }
}
