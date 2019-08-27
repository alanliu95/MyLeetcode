package com.alan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 组合总和 {
//    public static void main(String[] args) {
//        int[] candidates = {2, 3, 6, 7};
//        int target = 7;
//        组合总和 solution = new 组合总和();
//        List<List<Integer>> combinationSum = solution.combinationSum(candidates, target);
//        System.out.println(combinationSum);
//    }
//    private List<List<Integer>> res = new ArrayList<>();
//    private int[] candidates;
//    private int len;
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        int len = candidates.length;
//        if (len == 0) {
//            return res;
//        }
//        // 优化添加的代码1：先对数组排序，可以提前终止判断
//        Arrays.sort(candidates);
//        this.len = len;
//        this.candidates = candidates;
//        findCombinationSum(target, 0, new Stack<>());
//        return res;
//    }
//    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
//        if (residue == 0) {
//            // Java 中可变对象是引用传递，因此需要将当前 path 里的值拷贝出来
//            res.add(new ArrayList<>(pre));
//            return;
//        }
//        // 优化添加的代码2：在循环的时候做判断，尽量避免系统栈的深度
//        // residue - candidates[i] 表示下一轮的剩余，如果下一轮的剩余都小于 0 ，就没有必要进行后面的循环了
//        // 这一点基于原始数组是排序数组的前提，因为如果计算后面的剩余，只会越来越小
//        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
//            pre.add(candidates[i]);
//            // 【关键】因为元素可以重复使用，这里递归传递下去的是 i 而不是 i + 1
//            findCombinationSum(residue - candidates[i], i, pre);
//            pre.pop();
//        }
//    }


    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 4, 3};
        int tar = 11;
        System.out.println(new 组合总和().combinationSum(arr, tar));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(candidates, target, 0, new Stack<Integer>(), res);
        return res;
    }

    public void combinationSum(int[] candidates, int target, int index, Stack stack, List res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(stack));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            stack.push(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, stack, res);
            stack.pop();
        }

    }
}
