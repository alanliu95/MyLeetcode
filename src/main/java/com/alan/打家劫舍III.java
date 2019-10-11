package com.alan;


public class 打家劫舍III {
    public int rob(TreeNode root) {
        return robCore(root).val;
    }

    public TreeNode robCore(TreeNode root) {
        if (root == null) {
            TreeNode node = new TreeNode(0);
            return robCore(node);
        }
        if (root.left == null && root.right == null) {
            root.left = new TreeNode(0);
            root.right = new TreeNode(0);
            return root;
        }

        root.left = robCore(root.left);
        root.right = robCore(root.right);
        root.val = Math.max(root.val + root.left.left.val + root.left.right.val + root.right.left.val
                + root.right.right.val, root.left.val + root.right.val);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
