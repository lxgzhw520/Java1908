package com.lxgzhw.demo02;

public class Demo01 {
    public static void main(String[] args) {
        Zi zi = new Zi();
        //子类与父类变量重名的访问
        //就近原则,访问的是子类的变量
        System.out.println(zi.common);
    }
}
