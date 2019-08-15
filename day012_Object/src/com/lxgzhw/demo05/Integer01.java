package com.lxgzhw.demo05;

public class Integer01 {
    public static void main(String[] args) {
        //装箱:基本类型->包装类型
        //拆箱:包装类型->基本类型
        Integer integer = new Integer(1);
        System.out.println("装箱:" + integer);
        int i = integer;
        System.out.println("自动拆箱:" + i);
    }
}
