package com.alan.公司.字节跳动;
import java.util.Scanner;
public class 解密 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        char[] chars=scanner.next().toCharArray();
        boolean[] s=new boolean[n+k-1];
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]=='1')
                s[i]=true;
        }
        boolean[] res=new boolean[n];
        res[0]=s[0];
        for (int i = 1; i <n ; i++) {
            int tmp;
            if(i<k-1) tmp=i;
            else tmp=k-1;
            for (int j = i-1; j >=i-tmp ; j--) {
                res[i]=res[i]^res[j];
            }

            if(res[i]==s[i])
                res[i]=false;
            else res[i]=true;
        }
        char[] resChar=new char[n];
        for (int i = 0; i <n ; i++) {
            if (res[i]) resChar[i]='1';
            else resChar[i]='0';
        }
        System.out.println(new String(resChar));
    }
}
