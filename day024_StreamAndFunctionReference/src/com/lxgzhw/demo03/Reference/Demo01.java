package com.lxgzhw.demo03.Reference;

/*
方法引用:
    1.如果是函数式接口
    2.如果该方法已存在
    3.就可以使用方法引用
 */
public class Demo01 {
    //定义接口方法
    static void printString(Printable p) {
        p.print("Hello");
    }

    public static void main(String[] args) {
        //会把p.print(参数)中的参数传给printUpper
        printString(new Obj()::printUpper);
    }
}
