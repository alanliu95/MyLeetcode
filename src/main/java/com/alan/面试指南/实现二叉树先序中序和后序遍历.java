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
        preOrder_non_recursion(root);
        System.out.println();
        inOrder_non_recursion(root);
        System.out.println();
        postOrder_non_recursion(root);
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
    public static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    //4 5 2 6 8 7 3 1
    public static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }


    public static void preOrder_non_recursion(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || stack.size() > 0) {
            if (root != null) {
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }

    }

    public static void inOrder_non_recursion(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || stack.size() > 0) {
            if (root != null) {

                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }

    }

    public static void postOrder_non_recursion(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        if (root != null) {
            s1.push(root);
            while (!s1.isEmpty()) {
                root = s1.pop();
                s2.push(root);
                if (root.left != null)
                    s1.push(root.left);
                if (root.right != null)
                    s1.push(root.right);
            }
            while (!s2.isEmpty()) {
                root = s2.pop();
                System.out.print(root.val + " ");
            }
        }
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
