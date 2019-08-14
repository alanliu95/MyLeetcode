package com.alan.offer;

public class 翻转单词顺序列 {
    public static void main(String[] args) {
        System.out.println(new 翻转单词顺序列().ReverseSentence(" "));
    }
    public String ReverseSentence(String str) {
        if(str==null || str.length()==0||str.trim().equals("")) return str;
        String[] arr=str.split(" ");
        StringBuilder builder=new StringBuilder();
        for (int i = arr.length-1; i >0 ; i--) {
            builder.append(arr[i]+" ");
        }
        if(arr.length>0)
            builder.append(arr[0]);
        return builder.toString();
    }

    //如果输入字符串为"   ",无法处理
    public String ReverseSentence222(String str) {
        if(str==null || str.length()==0) return str;
        //待分割字符串为“  ”如何处理
        String[] arr=str.split(" ");
        StringBuilder builder=new StringBuilder();
        for (int i = arr.length-1; i >0 ; i--) {
            builder.append(arr[i]+" ");
        }
        if(arr.length>0)
            //不判断可能会越界
            builder.append(arr[0]);
        return builder.toString();
    }
}
