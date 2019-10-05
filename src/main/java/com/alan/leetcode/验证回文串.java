package com.alan.leetcode;

public class 验证回文串 {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(String s) {
        if(s==null||s.length()<2) return true;
        char[] chars=s.toCharArray();
        int cnt=0;
        for (int i = 0; i < chars.length; i++) {
            if((chars[i]>='0'&&chars[i]<='9')||(chars[i]>='a'&&chars[i]<='z')){
                chars[cnt++]=chars[i];
            }else if (chars[i]>='A'&&chars[i]<='Z'){
                chars[cnt++]= (char) (chars[i]-'A'+'a');
            }
        }
        cnt--;
        int index=0;
        while (index<cnt){
            if(chars[cnt--]!=chars[index++]){
                return false;
            }
        }
        return true;
    }
}
