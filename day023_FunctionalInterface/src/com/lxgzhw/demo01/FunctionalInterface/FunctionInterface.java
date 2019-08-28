package com.lxgzhw.demo01.FunctionalInterface;

/*
函数式接口:
    1.有且只有一个抽象方法的接口
    2.添加@FunctionalInterface注解
    3.可以包含其他方法(默认,静态,私有)
 */
@FunctionalInterface
public interface FunctionInterface {
    public abstract void method();
}
