package com.lxgzhw.demo03.Consumer;

import java.util.function.Consumer;

/*
Consumer接口的默认方法:andThen
    作用:
        1.可以把两个Consumer接口组合在一起
 */
public class Demo02 {
    //定义接口方法
    static void method(String s, Consumer<String> con1,
                       Consumer<String> con2) {
        con1.andThen(con2).accept(s);
    }

    //主方法
    public static void main(String[] args) {
        //会先执行con1,再执行con2
        //案例:将验证码全小写,然后全大写
        method("As4k", (captcha) -> {
            System.out.println(captcha.toLowerCase());
        }, (captcha) -> {
            System.out.println(captcha.toUpperCase());
        });
    }
}
