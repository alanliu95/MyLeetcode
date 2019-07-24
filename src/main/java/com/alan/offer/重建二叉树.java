package com.alan.offer;

public class 重建二叉树 {
}
/**
 * Definition for binary tree
 */
class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(in.length==0||in==null) return null;
        int N=in.length;
        return reConstructBinaryTree(pre,in,0,N-1,0,N-1);
    }
    private TreeNode reConstructBinaryTree(int [] pre,int [] in,int headPre, int tailPre, int headIn, int tailIn){
        if(headPre>tailPre) return null;
        int i=headIn;
        for(;i<=tailIn;i++){
            if(in[i]==pre[headPre]) break;
        }
        TreeNode root = new TreeNode(pre[headPre]);
        int lenLeft=i-headIn;
        int lenRight=tailIn-i;
        root.left=reConstructBinaryTree(pre,in,headPre+1, headPre+lenLeft, headIn, headIn+lenLeft-1);
        //root.right=reConstructBinaryTree(pre, in, tailPre-lenRight+1,tailPre,tailIn-lenRight+1,tailIn);
        root.right=reConstructBinaryTree(pre, in, tailPre-lenRight+1,tailPre,i+1,tailIn);
        return root;
    }
}