package com.lxgzhw.demo02;

interface Interface03 {
    void method();
}
interface Interface04 {
    void method();
}
//测试类
class Test02 implements Interface03,Interface04{
    @Override
    public void method() {
        System.out.println("重名方法只需实现一个.");
    }
}

