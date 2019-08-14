package com.alan.offer;

import java.util.Arrays;

public class 扑克牌顺子 {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length==0) return false;
        Arrays.sort(numbers);
        int have=0;
        int request=0;
        for (int i = 0; i <numbers.length-1 ; i++) {
            if(numbers[i]==0) {have++; continue;}
            if(numbers[i+1]-numbers[i]>0)
                request+=(numbers[i+1]-numbers[i]-1);
            else return false;

        }
        if(have>=request) return true;
        return false;
    }
}
