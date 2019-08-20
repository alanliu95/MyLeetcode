package com.alan.剑指offer;
import java.util.*;
public class 二叉树中和为某一值的路径 {
    public class Solution {
        private Stack<Integer> s;
        private ArrayList<ArrayList<Integer>> result;
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
            this.result= new ArrayList<ArrayList<Integer>>();
            this.s=new Stack<>();
            if(root!=null)
                find(root,target);
            return result;
        }
        void find(TreeNode root,int target){
            if(root.left==null && root.right==null){
                if(target==root.val){
                    s.push(root.val);
                    result.add(new ArrayList<Integer>(s));
                    s.pop();
                }
                return;
            }
            int tmp=target-root.val;
            s.push(root.val);

            if(root.left!=null) find(root.left,tmp);
            if(root.right!=null)  find(root.right,tmp);
            s.pop();
        }


    }
}
