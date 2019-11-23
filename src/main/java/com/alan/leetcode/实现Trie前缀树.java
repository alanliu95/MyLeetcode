package com.alan.leetcode;

public class 实现Trie前缀树 {
}

class Trie {
    private static int R = 256;
    private Node root; //根节点

    private static class Node {
        Integer val;
        Node[] next = new Node[R];
    }

    public void insert(String key) {
        root = put(root, key, 1, 0);
    }

    private Node put(Node x, String key, Integer val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public Boolean search(String key) {
        Node x = get(root, key, 0);
        if (x == null) return false;
        return true;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) {
            if (x.val == null)
                return null;
            else
                return x;
        }
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }

    private boolean startsWith(Node x, String prefix, int d) {
        if (x == null) return false;
        if (d == prefix.length()) return true;
        return startsWith(x.next[prefix.charAt(d)], prefix, d + 1);
    }
}