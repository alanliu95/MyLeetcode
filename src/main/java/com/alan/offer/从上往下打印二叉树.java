package com.alan.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 从上往下打印二叉树 {
    public class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> res=new ArrayList<>();
            Queue<TreeNode> q=new LinkedList<>();
            if(root==null) return res;
            q.offer(root);
            while(!q.isEmpty()){
                TreeNode ele=q.poll();
                res.add(ele.val);
                if(ele.left!=null) q.offer(ele.left);
                if(ele.right!=null) q.offer(ele.right);
            }
            return res;
        }
    }
}
