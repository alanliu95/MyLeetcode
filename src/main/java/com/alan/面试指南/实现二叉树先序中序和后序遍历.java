package com.alan.面试指南;

import java.util.Scanner;
import java.util.Stack;

public class 实现二叉树先序中序和后序遍历 {

    /*
        8 1
        1 2 3
        2 4 5
        4 0 0
        5 0 0
        3 6 7
        6 0 0
        7 8 0
        8 0 0
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        Node root = nodes[scanner.nextInt() - 1];
        for (int i = 0; i < n; i++) {
            int temp1 = scanner.nextInt();
            nodes[temp1 - 1].val = temp1;
            int temp2 = scanner.nextInt();
            if (temp2 > 0)
                nodes[temp1 - 1].left = nodes[temp2 - 1];
            temp2 = scanner.nextInt();
            if (temp2 > 0)
                nodes[temp1 - 1].right = nodes[temp2 - 1];
        }
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();

    }

    public static void inOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.print(curr + " ");
                curr = curr.right;
            }
        }
    }

    /**
     * 中序遍历 非递归写法
     *
     * @param root
     */
//    public static void  inOrder(Node root){
//        Stack<Node> stack=new Stack<>();
//        Node curr=root.left;
//        stack.push(root);
//        while(!stack.isEmpty()){
//            while(curr!=null){
//                stack.push(curr);
//                curr=curr.left;
//            }
//            curr=stack.pop();
//            System.out.print(curr.val+" ");
//            curr=curr.right;
//            if(curr!=null){
//                stack.push(curr);
//                curr=curr.left;
//            }
//        }
//        //System.out.println();
//    }


//    public static void  inOrder(Node root){
//        if(root==null)
//            return;
//        inOrder(root.left);
//        System.out.print(root.val+" ");
//        inOrder(root.right);
//
//    }


    //4 5 2 6 8 7 3 1
    public static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node() {
        }

        public void setChild(Node[] arr, int left, int right) {
            this.left = arr[left];
            this.right = arr[right];
        }
    }

}
