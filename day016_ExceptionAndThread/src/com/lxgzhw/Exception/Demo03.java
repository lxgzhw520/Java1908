package com.lxgzhw.Exception;

import java.util.Objects;

public class Demo03 {
    public static void main(String[] args) {
        //查看引用类型是否为null的专用方法
        method(null);
    }

    private static void method(Object o) {
        //这个方法会抛出异常,终止程序
        Objects.requireNonNull(o, "传递的对象值是null");
    }
}
