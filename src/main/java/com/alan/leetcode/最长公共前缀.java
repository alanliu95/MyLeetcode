package com.alan.leetcode;

public class 最长公共前缀 {
    public static void main(String[] args) {
        System.out.println("abc".substring(0,0));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i))
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix=strs[0];
        for (int i = 1; i <strs.length ; i++) {
            while (strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.equals(""))
                    return "";
            }

        }
        return prefix;
    }
}
