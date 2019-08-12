package com.lxgzhw.demo03;

public class PeronTest01 {
    public static void main(String[] args) {
        Person sunWuKong = new Person();

        //一旦设为private 外部就不能直接访问了
        //只能通过方法进行设置
//        sunWuKong.name = "孙悟空";
//        sunWuKong.age = 555;
        sunWuKong.setName("孙悟空");
        //使用一个不合理的年龄进行测试
        sunWuKong.setAge(-333);
        sunWuKong.show();
    }
}
