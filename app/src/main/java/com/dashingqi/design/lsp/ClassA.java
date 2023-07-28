package com.dashingqi.design.lsp;

/**
 * @author zhangqi61
 * @since 2023/7/24
 */
public class ClassA {
    int num = 1;

    static {
        System.out.println("static A");
    }

    {
        System.out.println("inner A");
    }

    public ClassA(){
        System.out.println("construction A");
    }
}
