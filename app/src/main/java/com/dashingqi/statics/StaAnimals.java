package com.dashingqi.statics;

/**
 * @author zhangqi61
 * @since 2023/5/19
 */
public class StaAnimals {
    public static int a;


    /**
     * 静态代码块是在JVM加载类的时候被执行
     * 静态成员变量可以在静态代码快中进行赋值
     */
    static {
        a = 5;
    }

    /**
     * 静态方法
     */
    public static void methodSta(){

    }
}
