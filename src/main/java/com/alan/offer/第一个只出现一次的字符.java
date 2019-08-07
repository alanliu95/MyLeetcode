package com.alan.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class 第一个只出现一次的字符 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true){
        String str=scanner.nextLine();
        int index=new 第一个只出现一次的字符().FirstNotRepeatingChar(str);
        System.out.println(index);
        }
    }
    public int FirstNotRepeatingChar(String str) {
        if(str==null || str.length()==0) return -1;
        LinkedHashMap<Character,Integer> count=new LinkedHashMap<>();
        char[] chars=str.toCharArray();
        for(int i=0;i<chars.length;i++){
            count.put(chars[i],count.getOrDefault(chars[i],0)+1);
        }
        char target=' ';
        for(int i=0;i<chars.length;i++){
            if(count.get(chars[i])==1){
                target=chars[i];
                return i;
            }
        }
        return -1;
    }
}
