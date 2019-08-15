package com.lxgzhw.demo06;

public class Main {
    public static void main(String[] args) {
        //创建笔记本
        LapTop mac = new LapTop("Mac", "白色", 14999);

        //笔记本开机
        mac.start();
        System.out.println("-------------------------------");

        //笔记本使用键盘
        USB keyboard = mac.useUsb(new Keyboard());
        keyboard.open();
        System.out.println("-------------------------------");

        //笔记本使用鼠标
        USB mouse = mac.useUsb(new Mouse());
        mouse.open();
        System.out.println("-------------------------------");

        //关闭鼠标 键盘 电脑
        mouse.close();
        keyboard.close();
        mac.powerOff();
    }
}
