package com.alan.offer;
public class 旋转数组最小元素 {
}
class Solution1 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0) return 0;
        //if (array[0]<=array[array.length-1]) return array[0];
        int head=0,tail=array.length-1;
        int mid=head;
        while(true){
            if(array[head]==array[mid]&&array[tail]==array[mid]){
                return order(array,head,tail);
            }
            if(tail-head==1){
                mid=tail;
                break;
            }
            mid=(head+tail)/2;
            if(array[mid]>=array[head]) head=mid;
            else if(array[mid]<=array[tail])  tail=mid;
        }
        return array[mid];
    }
    public int order(int[] array, int head, int tail){
        int min=Integer.MAX_VALUE;
        for(int i=head;i<=tail;i++){
            if(array[i]<min)
                min=array[i];
        }
        return min;
    }
}