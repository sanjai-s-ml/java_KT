package com.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem {
    public static void main(String[] args) {
        System.out.println("Even Numbers :");
        List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Stream<Integer> stream=numbers.stream().filter((Integer num)-> num%2==0);
        stream.forEach((Integer num)-> System.out.print(num+" "));
        System.out.println();

        List<String> str=Arrays.asList();
        String streams= String.valueOf(str.stream().max((s1, s2)-> Integer.compare(s1.length(),s2.length())).orElse(null));
        System.out.println("Longest String : "+streams);

        System.out.println("Remove Duplicates :");
        List<String> strs=Arrays.asList("Java","Python","JavaScript","Python","Ruby","Perl","Ruby");
        Stream<String> streamss=strs.stream().distinct();
        List<String> result=streamss.collect(Collectors.toList());
        System.out.println(result);

    }
}
