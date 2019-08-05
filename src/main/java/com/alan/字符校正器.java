package com.alan;

import java.util.Scanner;

import java.util.Scanner;

public class 字符校正器 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        while (n>0){
            String str=in.next();
            System.out.println(verify(str));
            n--;
        }
    }
    public static String verify(String str){
        //StringBuilder builder=new StringBuilder(str);
        if(str==null||str.length()<3) return str;
        int curr=0;
        while(curr< str.length()){
            if(curr+2<str.length())
                if(str.charAt(curr)==str.charAt(curr+1)&&str.charAt(curr+1)==str.charAt(curr+2)){
                    str=str.substring(0,curr+1)+str.substring(curr+2);
                    continue;
                }
            if(curr+3<str.length())
                if(str.charAt(curr)==str.charAt(curr+1)&&str.charAt(curr+2)==str.charAt(curr+3)){
                    str=str.substring(0,curr+2)+str.substring(curr+3);
                    continue;
                }
            curr++;
        }
        return str;
    }
}
