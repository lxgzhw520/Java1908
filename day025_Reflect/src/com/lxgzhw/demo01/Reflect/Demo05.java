package com.lxgzhw.demo01.Reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo05 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.创建Properties对象
        Properties properties = new Properties();
        //2.加载配置文件,转换为集合
        ClassLoader classLoader = Demo05.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("prop.properties");
        properties.load(resourceAsStream);
        //3.获取配置文件数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        //4.加载该类
        Class<?> aClass = Class.forName(className);
        //5.创建对象
        Object o = aClass.newInstance();
        //6.获取方法对象
        Method method = aClass.getMethod(methodName);
        //7.执行方法
        method.invoke(o);
    }
}
