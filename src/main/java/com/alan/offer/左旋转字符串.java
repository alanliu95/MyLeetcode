package com.alan.offer;

public class 左旋转字符串 {
    public static void main(String[] args) {
        System.out.println(new 左旋转字符串().LeftRotateString("abcdefg",2));
    }


    public String LeftRotateString(String str, int n) {
        char[] chars = str.toCharArray();
        if (chars.length < n) {
            return "";
        }
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);

        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    // 无法工作的代码
    public String LeftRotateString2(String str,int n) {
        if(str==null||str.length()==0) return str;
        n=n%str.length();
        int N=str.length();
        char[] chars=str.toCharArray();
        char tmp;
        for(int i=0;i<N/2;i++){
            tmp=chars[i];
            chars[i]=chars[N-i-1];
            chars[N-i-1]=tmp;
        }
        for(int i=N-n;i<(N-n)+n/2;i++){
            tmp=chars[i];
            chars[i]=chars[N-i-1];
            chars[N-i-1]=tmp;
        }
        for(int i=0;i<(N-n)/2;i++){
            tmp=chars[i];
            chars[i]=chars[N-n-i-1];
            chars[N-n-i-1]=tmp;
        }
        return new String(chars);
    }
}