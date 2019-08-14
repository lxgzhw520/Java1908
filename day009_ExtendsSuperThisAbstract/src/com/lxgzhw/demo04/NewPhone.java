package com.lxgzhw.demo04;

public class NewPhone extends Phone {
    @Override
    public void show(){
        //调用父类的功能
        super.show();
        //添加新的功能
        System.out.println("显示姓名");
        System.out.println("显示头像");
    }
}
