package com.alan.剑指offer;

public class 平衡二叉树 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);

        root.right=new TreeNode(3);
        root.right.right=new TreeNode(6);
        new 平衡二叉树().IsBalanced_Solution(root);
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        //空树
        if(root==null) return true;
        return Math.abs(dfs_max(root.left) - dfs_max(root.right)) <= 1
                && IsBalanced_Solution(root.left)
                && IsBalanced_Solution(root.right);
    }
    public int dfs_max(TreeNode root){
        if(root==null) return 0;
        return Math.max(dfs_max(root.left),dfs_max(root.right))+1;
    }
    public int dfs_min(TreeNode root){
        if(root.left==null&&root.right==null) return 1;
        int l=Integer.MAX_VALUE,r=Integer.MAX_VALUE;
        if(root.left!=null) l=dfs_min(root.left);
        if(root.right!=null) r=dfs_min(root.right);
        return Math.min(l,r)+1;
    }
}
