package com.lxgzhw.demo03.Generic;

/*
1.定义含有泛型的方法
2.格式
    修饰符 <泛型> 返回值类型 方法名(参数列表(泛型)){}
3.含有泛型的方法.调用时确定数据类型
4.传递什么类型的参数,泛型就是什么类型
 */

//泛型类是在 类名后面加<E>
//如public class GenericMethod<E>
public class GenericMethod {
    //定义一个含有泛型的方法
    public <M> void method(M m){
        System.out.println(m);
    }

    //定义一个含有泛型的静态方法
    public static <S> void method2(S s){
        System.out.println(s);
    }

}
