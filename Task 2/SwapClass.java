import java.util.*;
public class SwapClass {
    public static void main(String[] args) {
        Integer[] arr=new Integer[]{10,60,70,30,20,90};
        System.out.println("Before : ");
        display(arr);
        System.out.println();
        swap(arr,10,90);
        System.out.println("After : ");
        display(arr);
    }
    public static <T> void swap(T[]arr,T i,T j){
        int flag=0;
        for(int traverse=0;traverse<arr.length;traverse++){
            if(arr[traverse]== i){
                arr[traverse]=j;
                flag++;
            }
            else if(arr[traverse]==j){
                arr[traverse]=i;
                flag++;
            }
            if(flag==2) return ;

        }
        return ;
    }
    public static <T> void display(T[] arr){
        for(T a: arr){
            System.out.print(" "+a+" ");
        }
    }
}
