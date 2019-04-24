package com.alan;
/*
* 验证括号是否正常闭合
* ({}) true
* ({)} false
* */
class ParenthesisValid {
    public static void main( String[] args ){
        ParenthesisValid p=new ParenthesisValid();
        System.out.println(p.isValid("()"));
    }

    public boolean isValid(String s) {
        MyStack<Integer> stack= new MyStack<>();
        if(s.length()==0) return true;
        for(int i=0;i<s.length();i++){
            int c=0;
            switch (s.charAt(i)){
                case '(': {c=1;break;}
                case '[': {c=2;break;}
                case '{': {c=3;break;}
                case ')': {c=4;break;}
                case ']': {c=5;break;}
                case '}': {c=6;break;}
                default:  break;
            }
            if(c<4)
                stack.push(c);
            else if((!stack.isEmpty())&&c==stack.peek()+3)
            {
                stack.pop();
            }
            else
                return false;
        }
        return stack.isEmpty();
    }
}

class MyStack<Item>{
    private class Node{
        Item item;
        Node next;
    }
    private Node first;
    //    private Node last;
    private int n;
    public boolean isEmpty(){return (n==0);}
    public void push(Item item){
        Node oldFirst=first;
        first=new Node();
        first.item=item;
        first.next=oldFirst;
        n++;
    }
    public Item pop(){
        Item item=first.item;
        first=first.next;
        n--;
        return item;
    }
    public Item peek()
    {
        return first.item;
    }
}
