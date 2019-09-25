package com.alan.面试指南;

import java.util.Scanner;

public class 在二叉树中找到两个节点的最近公共祖先 {
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
        Node o1 = nodes[scanner.nextInt() - 1];
        Node o2 = nodes[scanner.nextInt() - 1];
        System.out.println(solution(root, o1, o2).val);
    }

    public static Node solution(Node root, Node o1, Node o2) {
        if (root == null || root == o1 || root == o2) {
            return root;
        }
        Node left = solution(root.left, o1, o2);
        Node right = solution(root.right, o1, o2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}

class Node {
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