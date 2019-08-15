package com.lxgzhw.demo06;

//键盘类,实现`usb`接口,具备敲击的方法
public class Keyboard implements USB{
    @Override
    public void open() {
        System.out.println("键盘USB插入成功");
    }

    @Override
    public void close() {
        System.out.println("键盘USB已拔出");
    }
    void click(){
        System.out.println("键盘在敲击");
    }
}
