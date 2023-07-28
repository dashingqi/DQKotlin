package com.dashingqi.design.lsp;

/**
 * @author zhangqi61
 * @since 2023/7/24
 */
public class LSPMain {

    public static void lspMethod() {
        // 里式替换原则
        ClassA classA = new ClassB();
//        int num = classA.num;
//        System.out.println("lsp->" + num);
        classA = new ClassB();
    }
}
