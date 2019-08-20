package com.alan.剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class 序列化二叉树 {
    public static void main(String[] args) {
//        TreeNode root=new TreeNode(4);
//        root.left=new TreeNode(3);
//        root.right=null;
//        System.out.println(new 序列化二叉树().Serialize(root));

        //String str="4,3,$,$,$";
        String str = "1,2,$,$,3,$,$";
        TreeNode root = new 序列化二叉树().Deserialize(str);
        System.out.println(new 序列化二叉树().Serialize(root));
    }

    String Serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        this.Serialize(root, builder);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    void Serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("$,");
            return;
        }
        builder.append(root.val + ",");
        Serialize(root.left, builder);
        Serialize(root.right, builder);

    }

    int index;

    TreeNode Deserialize(String str) {
        index = 0;
        String[] arr = str.split(",");
        return Deserialize(arr);
    }

    TreeNode Deserialize(String[] arr) {
        //if(index==arr.length-1) return null;
        TreeNode root;
        if (!arr[index].equals("$")) {
            root = new TreeNode(Integer.parseInt(arr[index]));
            index++;
            root.left = Deserialize(arr);
            index++;
            root.right = Deserialize(arr);
        } else
            return null;
        return root;
    }
}
