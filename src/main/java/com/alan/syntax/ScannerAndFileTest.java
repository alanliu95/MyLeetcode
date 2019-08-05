package com.alan.syntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerAndFileTest {
//    try(Scanner in=new Scanner(System.in)){
//
//    }
public static void main(String[] args) {
    Scanner in= null;
    try {
        in = new Scanner(new File("E:\\Liusong\\IDEAProjects\\MyLeetcode\\src\\main\\java\\com\\alan\\syntax\\hello.txt"));
        int n=in.nextInt();
        System.out.print(n);
        //System.out.printf(String.format("N=%d",n));
        //System.out.println("hello");
//        while(in.hasNext()){
//            System.out.println(in.nextLine());
//        }
        System.out.print(in.nextInt());
        //System.out.print(in.nextLine());
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

}
}
