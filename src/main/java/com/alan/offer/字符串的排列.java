package com.alan.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class 字符串的排列 {
    public static void main(String[] args) {
        String str="bacade";
        new Solution().Permutation(str);
    }
    public static class Solution {
        ArrayList<String> list;
        //HashSet<Character> set;
        boolean[] used;
        Stack<Character> stack;
        int N;
        public ArrayList<String> Permutation(String str) {
            list=new ArrayList();
            //set=new HashSet();
            stack=new Stack();
            char[] chars=str.toCharArray();
            N=chars.length;
            used=new boolean[chars.length];
            Arrays.sort(chars);
            System.out.println(new String(chars));
            return null;
        }
        void compute(char[] chars,int size){
            if(size==N){
                //顺序不对
                list.add(" ");
                return;
            }
            for(int i=0;i<N;i++){
                if(!used[i]){

                }
            }

        }
    }
}
