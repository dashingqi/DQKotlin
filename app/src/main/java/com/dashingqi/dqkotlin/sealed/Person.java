package com.dashingqi.dqkotlin.sealed;

/**
 * 定义一个枚举类
 * @author zhangqi61
 * @since 2021/12/27
 */
public enum Person {
    CHILDRNE("efdf"),
    MAN(1),
    WOMEN(2);
    private int age;
    private String name;

    private Person(int age) {
        this.age = age;
    }

    private Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
