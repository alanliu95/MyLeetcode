package com.alan.数据结构.字符串;

/**
 * 单词前缀树
 *
 * @param <V>
 */
public class TrieST<V> {
    public static void main(String[] args) {
        TrieST<Integer> trieST = new TrieST<>();
        String[] keys = new String[]{"she", "sells", "sea", "shells", "by", "the", "shore"};
        Integer[] values = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < keys.length; i++) {
            trieST.put(keys[i], values[i]);
        }
        for (int i = keys.length - 1; i >= 0; --i) {
            System.out.println(keys[i] + ":" + trieST.get(keys[i]));
        }
    }

    private static int R = 256;
    private Node root; //根节点

    private static class Node {
        Object val;
        Node[] next = new Node[R];
    }

    public void put(String key, V val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, V val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public V get(String key) {
        Node x = (Node) get(root, key, 0);
        if (x == null) return null;
        return (V) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }
}
