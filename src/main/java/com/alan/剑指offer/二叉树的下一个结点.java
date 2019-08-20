package com.alan.剑指offer;

public class 二叉树的下一个结点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null) return pNode;
        if(pNode.right!=null) return getNext1(pNode.right);
        return getNext2(pNode);

    }
    public  TreeLinkNode getNext1 (TreeLinkNode pNode){
        if(pNode.left!=null) return getNext1(pNode.left);
        return pNode;
    }
    public TreeLinkNode getNext2(TreeLinkNode pNode){
        if(pNode.next==null) return null;
        TreeLinkNode root=pNode.next;
        if(root.left==pNode) return root;
        else
            return getNext2(root);
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}