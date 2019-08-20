package com.alan.剑指offer;

public class 二叉搜索树的第k个结点 {
    int count;
    int k;
    TreeNode node;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) return pRoot;
        this.k = k;
        count = 0;
        KthNode(pRoot);
        if (count < k)
            return null;
        else return node;
    }

    void KthNode(TreeNode pRoot) {
        if (pRoot == null || count == k) return;
        KthNode(pRoot.left);
        count++;
        if (count == k) {
            node = pRoot;
        }
        KthNode(pRoot.right);
    }
}
