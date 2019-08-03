package com.alan.offer;
public class 二叉树的深度 {
    //方法垃圾
    public class Solution {
        private int max;
        public int TreeDepth(TreeNode root) {
            if(root==null) return 0;
            this.max=0;
            find(root,0);
            return max;
        }
        public void find(TreeNode root, int depth) {
            if(root==null) {
                max=max<depth?depth:max;
                return;
            }
            find(root.left,depth+1);
            find(root.right,depth+1);
        }
    }
}
