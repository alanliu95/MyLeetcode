package com.alan.剑指offer;

public class 二叉搜索树与双向链表 {
    TreeNode head = null;   //链表的头
    TreeNode tail = null;   //已经排完的末尾结点

    public TreeNode Convert(TreeNode pRootOfTree) {
        convertCore(pRootOfTree);
        return head;
    }

    public void convertCore(TreeNode root) {
        if (root == null) return;

        convertCore(root.left);

        root.left = tail;
        if (tail != null) tail.right = root;
        else head = root; // 当head为null时，此是刚遇到头

        tail = root;
        convertCore(root.right);
    }
}
