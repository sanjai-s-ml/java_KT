import java.util.*;
public class FrequencyChecker {
    public static void main(String[] args) {
        Map<Character,Integer> map=new HashMap<>();
        String str="Exception";
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> s:map.entrySet()){
            System.out.println(s.getKey() +" "+ s.getValue());
        }
    }
}
