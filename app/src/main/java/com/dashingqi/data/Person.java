package com.dashingqi.data;

/**
 * @author : zhangqi
 * @desc :
 * @time : 2022/2/26 11:43
 */
public class Person {

    private String name;
    private String blood;

    public Person(String name, String blood) {
        this.name = name;
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public void printName() {
        System.out.println("name is " + getName());
    }

    public void printBlood() {
        System.out.println("blood is " + getBlood());

    }
}
