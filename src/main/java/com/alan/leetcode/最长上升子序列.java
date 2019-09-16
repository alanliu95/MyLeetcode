package com.alan.leetcode;

import java.util.Arrays;

public class 最长上升子序列 {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new 最长上升子序列().lengthOfLIS(arr));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }
        Arrays.sort(dp);
        return dp[n - 1];
    }

    public int lengthOfLIS_二分查找(int[] nums) {
        int len = nums.length;
        // 特判
        if (len <= 1) {
            return len;
        }
        // tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
        int[] tail = new int[len];
        // 遍历第 1 个数，直接放在有序数组 tail 的开头
        tail[0] = nums[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引

        int end = 0;
        for (int i = 1; i < len; i++) {
            // 【逻辑 1】比 tail 数组实际有效的末尾的那个元素还大
            if (nums[i] > tail[end]) {
                // 直接添加在那个元素的后面，所以 end 先加 1
                end++;
                tail[end] = nums[i];
            } else {
                // 使用二分查找法，在有序数组 tail 中
                // 找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
                int left = 0;
                int right = end;
                while (left < right) {
                    // 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                    // int mid = left + (right - left) / 2;
                    int mid = left + ((right - left) >>> 1);
                    if (tail[mid] < nums[i]) {
                        // 中位数肯定不是要找的数，把它写在分支的前面
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                // 走到这里是因为 【逻辑 1】 的反面，因此一定能找到第 1 个大于等于 nums[i] 的元素
                // 因此，无需再单独判断
                tail[left] = nums[i];
            }
            // 调试方法
            // printArray(nums[i], tail);
        }
        // 此时 end 是有序数组 tail 最后一个元素的索引
        // 题目要求返回的是长度，因此 +1 后返回
        end++;
        return end;
    }


//    public int lengthOfLIS_binarySearch(int[] nums){
//        //int res=1;
//        MyArr myArr=new MyArr(nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            //int index=myArr.search(nums[i]);
//            //res=Math.max(res,index);
//            myArr.insert(nums[i]);
//        }
//        return myArr.size();
//    }
}

//class MyArr{
//    private int[] arr;
//    private int size;
//    public MyArr(int n){
//        arr=new int[n];
//    }
//    public int search(int target){
//        if (size==0) return 0;
//        int lo=0,hi=size-1;
//        while (lo<hi){
//            int mid=(lo+hi)/2;
//            if(arr[mid]<target) lo=mid+1;
//            else if (arr[mid]>target) hi=mid-1;
//            else {
//                lo=mid;
//            }
//        }
//        return lo;
//    }
//    public void insert(int index, int val){
//        if(arr[index]==val){
//            return;
//        }
//        for (int i = size; i >index ; i--) {
//            arr[i]=arr[i-1];
//        }
//        arr[index]=val;
//        size++;
//    }
//    public void insert(int val){
//        int index=search(val);
//        if(index<=size-1 && arr[index]>val){
//            arr[index]=val;
//            size=index+1;
//        }
//        else{
//
//        }
//    }
//    public int size(){
//        return size;
//    }
//}