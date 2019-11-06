package com.alan.syntax;

public class 枚举类 {
    public static void main(String[] args) {
        System.out.println(Gender.valueOf("MALE1").getDesc());
    }
}

enum Gender {
    MALE1(1, "Male"), FEMALE1(2, "Female");
    private int value;
    private String desc;

    private Gender(int num, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
