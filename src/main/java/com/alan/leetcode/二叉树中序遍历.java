package com.alan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树中序遍历 {
    static List<Integer> list;

    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();  //领扣oj有问题，为避免问题在此初始化对象变量list
        if (root == null) return list;
        mid_iterate(root);
        return list;

    }

    private void mid_iterate(TreeNode parent) {
        if (parent.left != null) mid_iterate(parent.left);
        list.add(parent.val);
        if (parent.right != null) mid_iterate(parent.right);
        return;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }