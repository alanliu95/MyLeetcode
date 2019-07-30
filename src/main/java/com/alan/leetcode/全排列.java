package com.alan.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 全排列 {
}

class 全排列Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len=nums.length;

        boolean[] visited=new boolean[len];
        Stack<Integer> path= new Stack<>();
        List<List<Integer>> res=new ArrayList<>();
        if (len == 0) {
            return res;
        }
        generatePermution(nums,visited,0,len,path,res);
        return res;
    }
    public void generatePermution(int[] nums, boolean[] visited, int currSize, int len, Stack<Integer> path, List<List<Integer>> res){
        if(currSize==len){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i=0;i<len;i++){
            if(!visited[i]){
                visited[i]=true;
                path.push(nums[i]);
                generatePermution(nums,visited,currSize+1,len,path,res);
                //currSize--;
                path.pop();
                visited[i]=false;
            }

        }
    }

}
