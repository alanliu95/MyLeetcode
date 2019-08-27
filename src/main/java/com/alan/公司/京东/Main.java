package com.alan.公司.京东;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        B obj = new B();
        System.out.println(obj.x);
    }
}

class A {
    int x = 10;

    public A() {
        System.out.println("A");

    }
}

class B extends A {
    int x = 9;

    public B() {
        System.out.println("B");

    }
}
