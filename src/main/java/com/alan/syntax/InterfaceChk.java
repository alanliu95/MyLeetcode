package com.alan.syntax;

public class InterfaceChk implements Comparable<InterfaceChk>{
    private String val;

    public InterfaceChk(String val) {
        this.val = val;
    }

    @Override
    public int compareTo(InterfaceChk o) {
        return val.compareTo(o.val);
    }
    public static void main(String[] args){
        Comparable i1=new InterfaceChk("c");
        Comparable i2=new InterfaceChk("b");
//        Comparable i2="b";
        System.out.println(i1.compareTo(i2));
    }
}
