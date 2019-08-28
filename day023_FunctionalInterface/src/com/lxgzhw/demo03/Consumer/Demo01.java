package com.lxgzhw.demo03.Consumer;

import java.util.function.Consumer;

/*
消费型函数式接口Consumer<T>:
    1.特点:给什么类型的数据,就消费什么类型的数据
    2.抽象方法:accept(T t)
 */
public class Demo01 {
    //定义接口方法
    static void method(String name, Consumer<String> con) {
        //对姓名进行消费
        con.accept(name);
    }

    //入口:主方法
    public static void main(String[] args) {
        //案例:反转字符串
        method("楚枫", (String name) -> {
            String reName = new StringBuffer(name).reverse().toString();
            System.out.println("反转后的名字:" + reName);
        });
    }
}
