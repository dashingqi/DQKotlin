package com.dashingqi.arithmetic.stack;

/**
 * @author : zhangqi
 * @desc : 数组实现的栈
 * @time : 2023/2/19 16:57
 */
public class ArrayStack {

    /**
     * 栈中元素的个数
     */
    private int stackCount;

    /**
     * 栈的大小
     */
    private final int stackSize;

    /**
     * 数组
     */
    private final String[] arrayStack;

    public ArrayStack(int stackSize) {
        this.arrayStack = new String[stackSize];
        this.stackSize = stackSize;
        // 一开始初始化时，栈中元素个数为0
        stackCount = 0;
    }

    /**
     * 入栈
     *
     * @param item 元素
     * @return true/false
     */
    public boolean push(String item) {
        // 如果当前栈满了就不需要入栈，直接返回false
        if (stackCount == stackSize) return false;
        arrayStack[stackCount] = item;
        ++stackCount;
        return true;
    }

    /**
     * 出栈
     *
     * @return 栈中元素
     */
    public String pop() {
        // 当栈中没有存储的元素时就返回null
        if (stackCount == 0) return null;
        String tempItem = arrayStack[stackCount - 1];
        --stackCount;
        return tempItem;
    }

}
