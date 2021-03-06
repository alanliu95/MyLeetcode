package com.alan.剑指offer;

import java.util.*;

public class 字符串的排列 {
    public static void main(String[] args) {
        String str="abc";
        List<String> list=new Solution().Permutation(str);
        System.out.println(list);
    }
    public static class Solution2 {
        //结果
        ArrayList<String> list;
        //HashSet<Character> set;
        //记录元素是否使用过
        boolean[] used;
        //按顺序记录已被使用的元素
        char[] tmp;
        int N;
        public ArrayList<String> Permutation(String str) {
            list=new ArrayList();
            if(str==null||str.length()==0) return list;

            char[] chars=str.toCharArray();
            N=chars.length;
            used=new boolean[N];
            tmp=new char[N];
            Arrays.sort(chars);
            compute(chars,0);
            return list;
        }
        void compute(char[] chars,int size){
            if(size==N){
                list.add(new String(tmp));
                return;
            }
            Set<Character> set=new HashSet<>();
            for(int i=0;i<N;i++){
                if(!used[i] && !set.contains(chars[i])){
                    set.add(chars[i]);
                    used[i]=true;
                    tmp[size]=chars[i];
                    compute(chars,size+1);
                    used[i]=false;
                }
            }

        }
    }
    public static class Solution {
        //结果
        ArrayList<String> list;
        //HashSet<Character> set;
        //记录元素是否使用过
        boolean[] used;
        //按顺序记录已被使用的元素
        LinkedList<Character> deque;
        int N;
        public ArrayList<String> Permutation(String str) {
            list=new ArrayList();
            if(str==null||str.length()==0) return list;
            //存结果

            //set=new HashSet();
            deque=new LinkedList<Character>();
            char[] chars=str.toCharArray();
            N=chars.length;
            used=new boolean[chars.length];
            Arrays.sort(chars);
            //System.out.println(new String(chars));
            compute(chars,0);
            return list;
        }
        void compute(char[] chars,int size){
            if(size==N){
                //顺序不对
                char[] tmp=new char[N];
                int i=0;
                Deque<Character> copy=(Deque<Character>)deque.clone();
                while(copy.size()>0){
                    tmp[i++]=copy.removeFirst();
                }

                list.add(new String(tmp));
                return;
            }
            Set<Character> set=new HashSet<>();
            for(int i=0;i<N;i++){

                if(!used[i]){
                    if(set.contains(chars[i])) continue;
                    set.add(chars[i]);
                    used[i]=true;
                    deque.addLast(chars[i]);
                    compute(chars,size+1);
                    used[i]=false;
                    deque.pollLast();
                }
            }

        }
    }
}
