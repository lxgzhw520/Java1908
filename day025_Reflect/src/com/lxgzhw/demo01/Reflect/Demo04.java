package com.lxgzhw.demo01.Reflect;

import com.lxgzhw.domain.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
通过反射获取成员方法:
    1.getMethod
    2.getDeclaredMethod
 */
public class Demo04 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<Student> studentClass = Student.class;
        //1.获取Student类的公开方法
        Method show = studentClass.getMethod("show");
        //2.调用方法
        /*
        注意:
            1.调用方法不能直接调用,需要依赖invoke方法
            2.参数是一个类的实例对象
         */
        //show.invoke(new Student());
        show.invoke(studentClass.newInstance());
    }
}
