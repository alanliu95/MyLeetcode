package com.alan.剑指offer;

public class 字符流中第一个不重复的字符 {
    //Insert one char from stringstream
    int[] occurrence=new int[256];
    int index;
    public 字符流中第一个不重复的字符(){
        for(int i=0;i<256;i++){
            occurrence[i]=-1;
        }
    }
    public void Insert(char ch)
    {

        if(occurrence[ch]==-1)
            occurrence[ch]=index;
        else if(occurrence[ch]>=0)
            occurrence[ch]=-2;
        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char ch = '\0';
        int minIndex = Integer.MAX_VALUE;
        for(int i=0;i<256;i++){
            if(occurrence[i] >=0 && occurrence[i]<minIndex){
                ch = (char)i;
                minIndex = occurrence[i];
            }
        }
        if(ch == '\0')
            return '#';
        return ch;
    }
}
