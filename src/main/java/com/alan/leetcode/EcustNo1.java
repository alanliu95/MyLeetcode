package com.alan.leetcode;

import java.util.Scanner;

/*
*   字符串子序列：字符串删除部分字符后（或不删除）形成的字符串
*   计算目标字符串需要多少个 源字符串的子序列构成，若无法构成，返回-1
*   source: xyz target:xyxzy   需要三个子序列 xy + xz + y
* */
public class EcustNo1 {
    String src;
    String target;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String src=scanner.nextLine();
        String target=scanner.nextLine();
        //scanner.close();
        System.out.printf("%s %s \n",src,target);
        System.out.println(new EcustNo1().count(src,target));
    }
     public int count(String src,String target){
         this.src=src;
         this.target=target;
         int s=0,t=0;
         int cnt=0;
         while(t<target.length()){
             s=count2(t);
             if(s==t) return -1;
             else if (s==-1)  return -1;
             else{
                 t=s;
                 cnt++;
             }
         }
         return cnt;

     }
    public int count2(int start){
        int s=0;
        while(start<this.target.length()|| s==this.src.length()){
            s=this.src.substring(s).indexOf(target.charAt(start));
            if(s==-1) return start;
            else
            {
                start++;
                s++;
            }
        }
        return start;
    }
}
