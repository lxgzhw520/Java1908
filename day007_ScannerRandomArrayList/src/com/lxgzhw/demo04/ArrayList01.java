package com.lxgzhw.demo04;

public class ArrayList01 {
    public static void main(String[] args) {
        //首先创建一个长度为3的数组,里面用来存放Person类型的数组
        Person[] arr = new Person[3];

        //查看引用类型的默认值
        //System.out.println(arr[0]);

        //创建三个对象
        Person cuFeng = new Person("楚枫", 22);
        Person cuiCui = new Person("萃萃", 20);
        Person daHuang = new Person("大黄", 300);

        //进行赋值
        arr[0] = cuFeng;
        arr[1] = cuiCui;
        arr[2] = daHuang;

        //使用
        System.out.println(arr[0].getName());
    }
}
