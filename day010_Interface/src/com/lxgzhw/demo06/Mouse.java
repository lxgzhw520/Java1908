package com.lxgzhw.demo06;
//鼠标类,实现`usb`接口,具备点击的方法
public class Mouse implements USB {
    void click(){
        System.out.println("鼠标在点击");
    }

    @Override
    public void open() {
        System.out.println("鼠标USB连接成功.");
    }

    @Override
    public void close() {
        System.out.println("鼠标USB已拔出.");
    }
}
