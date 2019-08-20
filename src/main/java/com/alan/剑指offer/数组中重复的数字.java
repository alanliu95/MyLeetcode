package com.alan.剑指offer;

public class 数组中重复的数字 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||numbers.length==0) { duplication[0]=-1;return false;}
        int index=0;
        while(index<numbers.length){
            if(numbers[index]!=index){
                if(numbers[numbers[index]]==numbers[index]){
                    duplication[0]=numbers[index];
                    return true;
                }
                else{
                    int tmp=numbers[index];
                    numbers[index]=numbers[tmp];
                    numbers[tmp]=tmp;
                }

            }
            else
                index++;
        }
        duplication[0]=-1;
        return false;
    }
}
