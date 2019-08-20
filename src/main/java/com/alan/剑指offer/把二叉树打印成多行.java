package com.alan.剑指offer;
import java.util.*;
public class 把二叉树打印成多行 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        queue.add(pRoot);
        int cnt=0,level_cnt=1;
        while(queue.isEmpty()){
            TreeNode node=queue.poll();
            temp.add(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
            if(++cnt==level_cnt){
                result.add(temp);
                temp=new ArrayList<>();
                cnt=0;
                level_cnt=queue.size();
            }
        }
        return result;

    }
}
