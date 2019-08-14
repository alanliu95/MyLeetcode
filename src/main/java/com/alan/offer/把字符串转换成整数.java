package com.alan.offer;

public class 把字符串转换成整数 {
    public int StrToInt(String str) {
        if(str==null || str.length()==0) return 0;
        char[] chars=str.toCharArray();
        boolean positive=true;
        int index=0;
        switch(chars[0]){
            case '+':
                positive=true;
                index=1;
                break;
            case '-':
                positive=false;
                index=1;
                break;
            default: break;
        }
        int res=0;
        while(index<chars.length){
            if(chars[index]>='0'&&chars[index]<='9'){
                int num=chars[index]-'0';
                res=res*10+num;
                index++;
            }
            else{
                return 0;
            }
        }
        if(!positive)
            return -res;
        return res;
    }
}
