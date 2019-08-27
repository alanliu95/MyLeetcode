package com.alan.leetcode;

import java.util.*;

public class 组合总和II {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> combinationSum2 = new 组合总和II().combinationSum2(candidates, target);
        System.out.println(combinationSum2);
    }

    // residue 表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
    // residue 在递归遍历中，只会越来越小
    private void findCombinationSum2(int[] candidates, int begin, int len, int residue, Stack<Integer> stack, List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len && residue - candidates[i] >= 0; i++) {
            // 这一步之所以能够生效，其前提是数组一定是排好序的，这样才能保证：
            // 在递归调用的统一深度（层）中，一个元素只使用一次。
            // 这一步剪枝操作基于 candidates 数组是排序数组的前提下
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.add(candidates[i]);
            // 【关键】因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            findCombinationSum2(candidates, i + 1, len, residue - candidates[i], stack, res);
            stack.pop();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);
        findCombinationSum2(candidates, 0, len, target, new Stack<>(), res);
        return res;
    }


    //    public static void main(String[] args) {
//        int[] candidates = new int[]{10,1,2,7,6,1,5};
//        int target = 8;
//        System.out.println(new 组合总和II().combinationSum2(candidates,target));
//    }
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        result=new ArrayList<>();
//        //temp=new ArrayList<>();
//        map=new HashMap<>();
////        for (int i = 0; i < candidates.length; i++) {
////            map.put(candidates[i],map.getOrDefault(candidates[i],0)+1);
////        }
//        dfs(candidates,target,true,0);
//        return result;
//    }
//    List<List<Integer>> result;
//    List<Integer> temp;
//    HashMap<Integer,Integer> map;
//
//    public void dfs(int[] candidates,int target, boolean isFirst,int currIndex){
//        if(target==0){
//            List<Integer> list=new ArrayList<Integer>();
//            list.addAll(temp);
//            result.add(list);
//            return;
//        }
//        if(target<0||currIndex==candidates.length)
//            return;
//
//
//        for (int i = currIndex; i <candidates.length ; i++) {
//            if(isFirst){
//                if(!map.containsKey(candidates[i])) {
//                    map.put(candidates[i], 1);
//                    temp = new ArrayList<>(candidates.length);
//                }
//                else{
//                    continue;
//                }
//
//            }
//            temp.add(candidates[i]);
//            dfs(candidates,target-candidates[i],false,i+1);
//            temp.remove(new Integer(candidates[i]));
//        }
//
//    }
}
