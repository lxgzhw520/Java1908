package com.lxgzhw.demo05;

public class Zi extends Fu {
    public Zi(){
        super(20);
        //子类必须调用父类构造方法 super()
        System.out.println("子类构造方法");
    }

}
