package com.alan.剑指offer;
import java.util.*;
public class 数组中只出现一次的数字 {
    //num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
    public class Solution {
        public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
            int tmp=0;
            for(int e:array){
                tmp^=e;
            }
            int nBit=1;
            while((tmp&1)==0)
            {
                nBit<<=1;
                tmp=tmp>>1;
            }
            //开辟了额外空间
            ArrayList<Integer> l1=new ArrayList<>();
            ArrayList<Integer> l2=new ArrayList<>();
            for(int e:array){
                if((e&nBit)!=0)
                    l1.add(e);
                else l2.add(e);
            }
            num1[0]=yihuo(l1);
            num2[0]=yihuo(l2);
        }
        public int yihuo(List<Integer> l){
            int res=0;
            for(int e:l){
                res=res^e;
            }
            return res;
        }
    }
    public class Solution2 {
        public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
            int tmp=0;
            for(int e:array){
                tmp^=e;
            }
            int nBit=1;
            while((tmp&1)==0)
            {
                nBit<<=1;
                tmp=tmp>>1;
            }
            num1[0]=0;
            num2[0]=0;
            for(int e:array){
                if((e&nBit)!=0)
                    num1[0]^=e;
                else num2[0]^=e;
            }
        }
    }
}
