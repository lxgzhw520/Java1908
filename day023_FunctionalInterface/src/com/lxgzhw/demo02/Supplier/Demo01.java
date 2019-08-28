package com.lxgzhw.demo02.Supplier;

import java.util.function.Supplier;

public class Demo01 {
    //定义接口方法
    static String getString(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        //生产型函数式接口:Supplier<T>
        //作用:传什么类型,就得到什么类型

        //使用接口方法
        String cuFeng = getString(() -> "楚枫");
        System.out.println(cuFeng);
    }
}
