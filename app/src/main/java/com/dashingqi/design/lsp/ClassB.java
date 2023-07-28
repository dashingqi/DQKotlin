package com.dashingqi.design.lsp;

/**
 * @author zhangqi61
 * @since 2023/7/24
 */
public class ClassB extends ClassA {
    int num = 3;

    static {
        System.out.println("static B");
    }

    {
        System.out.println("inner B");
    }

    public ClassB(){
        System.out.println("construction B");
    }
}
