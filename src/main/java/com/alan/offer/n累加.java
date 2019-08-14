package com.alan.offer;

public class n累加 {
    public int Sum_Solution(int n) {
        return sum(n);
    }
    int sum(int n){
        try{
            int i = 1%n;
            return n+sum(n-1);
        }
        catch(Exception e){
            return 0;
        }
    }
}
