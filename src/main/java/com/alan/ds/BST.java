package com.alan.ds;

public class BST<Key extends Comparable<Key>, Value> {
    public static void main(String[] args){
        BST<Integer,Integer> bst = new BST<>();
        bst.put(3,3);
        bst.put(2,2);
        bst.put(5,5);
        bst.put(1,1);
        bst.put(4,4);
        bst.put(6,6);
        bst.print();
    }

    private Node root;
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public void put(Key key, Value val){
        root=put(root,key,val);
    }

    private Node put(Node x, Key key, Value val){
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);          //注意
        else if (cmp > 0) x.right = put(x.right, key, val);   //注意
        else x.val = val;
        x.N = size(x.right)+ size(x.left)+ 1;
        return x;
    }
    private int size(Node x){
        if(x==null) return 0;
        else return x.N;
    }

    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node x,Key key){
        if (x==null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp<0)  return get(x.left,key);
        else if(cmp>0)  return  get(x.right,key);
        else return x.val;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left==null) return x;
            return min(x.left);

    }

    public void deleteMin(){
        root=deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x.left== null) return x.right;
        x.left=deleteMin(x.left);
        x.N=size(x.left)+size(x.right)+1;
        return x;

    }

    public void print(){
        print(root);
    }

    private void print(Node x){
        if(x==null) return;
        print(x.left);
        System.out.println(x.key);
        print(x.right);
    }
}
