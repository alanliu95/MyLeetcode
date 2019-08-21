package com.alan.剑指offer;
import java.util.*;
public class 把二叉树打印成多行 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(7);
        System.out.println(new 把二叉树打印成多行().Print(root));
    }
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        queue.add(pRoot);
        int cnt=0,level_cnt=1;
        System.out.println(queue.size());
        //如果队列不为空，继续循环，!queue.isEmpty()
        while (!queue.isEmpty()) {
            TreeNode node=queue.poll();
            temp.add(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
            if(++cnt==level_cnt){
                result.add(temp);
                temp=new ArrayList<>();
                cnt=0;
                //根据队列长度可以获取到下一层节点数
                level_cnt=queue.size();
            }
        }
        return result;

    }
}
