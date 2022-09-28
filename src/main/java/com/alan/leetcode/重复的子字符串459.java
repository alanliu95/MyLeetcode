package com.alan.leetcode;

public class 重复的子字符串459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1)
            return true;
        if (s.length() == 2)
            return s.charAt(0) == s.charAt(1);

        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i != 0)
                continue;
            String sub = s.substring(0, i);
            int j = i;
            for (; j < s.length(); j += i) {
                if (!sub.equals(s.substring(j, j + i)))
                    break;
            }
            if (j == s.length())
                return true;
        }
        return false;
    }

    public boolean solution2(String s){
        return  (s+s).indexOf(s,1)<s.length();
    }

    // todo  kmp 算法  time：On  space On

    public static void main(String[] args) {
       boolean b= new 重复的子字符串459().repeatedSubstringPattern("aba");
        System.out.println(b);
        "".indexOf("ab",1);
    }
}
