package com.dashingqi.generics

/**
 * 协变 逆变
 * @author zhangqi61
 * @since 2022/10/24
 *
 * 程序是将现实生活进行抽象
 * 我们的范性是对程序的抽象
 *
 * 本来写程序就是一件比较抽象的事情，范性就更加抽象，不太好理解
 *
 * 程序是对显示生活的一种抽象
 * 泛型是在此基础之上对程序的一种抽象
 *
 *
 *
 * 上界：
 * 下界：
 *
 * 父子关系颠倒的现象:逆变 如果A是B的子类，那么Generics<A>是Generics<B>的父类
 * 父子关系一致的现象:协变 如果A是B的子类，那么Generics<A> 也是Generics<B>的子类
 * out 关键字声明协变
 * in  关键字声明逆变
 *
 * 星投影
 * 用星号作为泛型的实参，当我们不关心实参到底是什么类型的时候；
 *
 */


/** 打开*/
fun <T : TV> turnOn(t: T) {}

/** 关闭*/
fun <T> turnOff(t: T) {}

