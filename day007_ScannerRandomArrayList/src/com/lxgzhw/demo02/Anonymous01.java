package com.lxgzhw.demo02;

public class Anonymous01 {
    public static void main(String[] args) {

        //正常情况
        Person cuFeng = new Person("楚枫", 33);
        System.out.println(cuFeng.getName());

        //匿名对象的情况
        System.out.println(new Person("萃萃", 22).getName());
    }
}
