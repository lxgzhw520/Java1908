# `day018`  `Lambda`表达式

## 001.多线程案例

> 包子类

```java
package com.lxgzhw.demo01.WaitAndNotify;

/*
包子
 */
public class SteamedStuffedBun {
    //皮
    private String skin;
    //馅儿
    private String filling;
    //包子的状态 有还是没有
    private boolean status;

    public SteamedStuffedBun() {
    }

    public SteamedStuffedBun(String skin, String filling, boolean status) {
        this.skin = skin;
        this.filling = filling;
        this.status = status;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SteamedStuffedBun{" +
                "skin='" + skin + '\'' +
                ", filling='" + filling + '\'' +
                ", status=" + status +
                '}';
    }
}
```

> 包子铺类

```java
package com.lxgzhw.demo01.WaitAndNotify;

/*
包子铺
 */
public class Costs extends Thread {
    //1.创建包子
    private SteamedStuffedBun steamedStuffedBun;
    //2.给包子赋值
    public Costs(SteamedStuffedBun steamedStuffedBun){
        this.steamedStuffedBun=steamedStuffedBun;
    }
    //3.线程任务生产包子


    @Override
    public void run() {
        //统计变量
        int count=0;
        //包子铺一直生产包子
        while (true){
            //同步技术保证只有一个线程在同时执行
            synchronized (steamedStuffedBun){
                //如果有包子,就等待
                if (steamedStuffedBun.isStatus()){
                    try {
                        steamedStuffedBun.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //交替生产三种包子
                if (count%3==0){
                    //猪肉大葱
                    steamedStuffedBun.setSkin("猪肉");
                    steamedStuffedBun.setFilling("大葱");
                }else if (count%3==1){
                    //韭菜鸡蛋
                    steamedStuffedBun.setSkin("韭菜");
                    steamedStuffedBun.setFilling("鸡蛋");
                }else if (count%3==2){
                    //灌汤包
                    steamedStuffedBun.setSkin("灌汤");
                    steamedStuffedBun.setFilling("包");
                }
                //让统计变量自增
                count++;
                //生产包子
                System.out.println("包子铺正在生产"+
                        steamedStuffedBun.getSkin()+
                        steamedStuffedBun.getFilling()+
                        "包子");
                //等待时间
                try {
                    //线程休眠五秒钟
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //有包子了,修改包子的状态
                steamedStuffedBun.setStatus(true);
                //随机唤醒消费者线程
                steamedStuffedBun.notify();
                System.out.println("您要的包子做好了.");
            }
        }
    }
}
```

> 消费者类

```java
package com.lxgzhw.demo01.WaitAndNotify;
/*
顾客
 */
public class Customer extends Thread {
    private SteamedStuffedBun steamedStuffedBun;
    public Customer(SteamedStuffedBun steamedStuffedBun){
        this.steamedStuffedBun=steamedStuffedBun;
    }

    @Override
    public void run() {
        while (true){
            synchronized (steamedStuffedBun){
                if (!steamedStuffedBun.isStatus()){
                    //没有包子就等待
                    try {
                        steamedStuffedBun.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //有包子就开始吃
                System.out.println("顾客正在吃"+
                        steamedStuffedBun.getSkin()+
                        steamedStuffedBun.getFilling()+
                        "包子");
                //包子吃完,修改状态
                steamedStuffedBun.setStatus(false);
                System.out.println("顾客吃完了"+
                        steamedStuffedBun.getSkin()+
                        steamedStuffedBun.getFilling()+
                        "包子");
                System.out.println("-------------------------------");
            }
        }
    }
}
```

> 测试类

```java
package com.lxgzhw.demo01.WaitAndNotify;

/*
测试类
 */
public class Demo {
    public static void main(String[] args) {
        //1.创建包子
        SteamedStuffedBun steamedStuffedBun = new SteamedStuffedBun();
        //2.创建包子铺线程,生产包子
        new Costs(steamedStuffedBun).start();
        //3.创建消费者线程,吃包子
        new Customer(steamedStuffedBun).start();
    }
}
```



## 002.线程池

> Runnable实现类

```java
package com.lxgzhw.demo02.ThreadPool;

public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+
                "创建了一个新线程.");
    }
}
```

> 线程池测试类

```java
package com.lxgzhw.demo02.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo01 {
    public static void main(String[] args) {
        //线程池的使用
        //1.创建固定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //2.添加线程
        executorService.submit(new RunnableImpl());
        executorService.submit(new RunnableImpl());
    }
}
```



## 003.创建多线程的三种方法

```java
package com.lxgzhw.demo03.Lambda;
import com.lxgzhw.demo02.ThreadPool.RunnableImpl;
public class Demo01Runnable {
    public static void main(String[] args) {
        //使用前面的接口实现类
        RunnableImpl runnable = new RunnableImpl();
        //创建新线程的方法1
        Thread thread = new Thread(runnable);
        thread.start();

        //创建多线程的方法2
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("创建了新线程.");
            }
        };
        new Thread(runnable1).start();

        //创建多线程的方法3
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("创建了新线程.");
            }
        }).start();


    }
}
```



## 004.`Lambda`表达式

```java
package com.lxgzhw.demo03.Lambda;

public class Demo02Lambda {
    public static void main(String[] args) {
        //Lambda表达式实际上JavaScript中的函数新型表达式
        //格式 ()->{}
        //实现多线程的测试

        //方法1
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类的多线程.");
            }
        }).start();
        System.out.println("-------------------------------");
        //方法2
        new Thread(() -> {
            System.out.println("Lambda表达式多线程");
        }).start();
        System.out.println("-------------------------------");
        //方法3
        new Thread(() -> System.out.println("如果函数体" +
                "只有一行,可以省略大括号.")).start();
        System.out.println("-------------------------------");
    }
}
```



## 005.简化对象数组排序写法

```java
package com.lxgzhw.demo04.Lambda;

import java.util.Arrays;

public class Demo01Arrays {
    public static void main(String[] args) {
        //使用Lambda表达式简化数组对象排序写法
        //创建三个人的数组
        Person[] arr = {
                new Person("楚枫", 22),
                new Person("萃萃", 18),
                new Person("大黄", 333),
        };
        //按年龄升序
        Arrays.sort(arr, (o1, o2) -> o1.getAge() - o2.getAge());
        //打印
        printArray(arr);
        //按年龄降序
        Arrays.sort(arr, (o1, o2) -> o2.getAge() - o1.getAge());
        printArray(arr);
    }

    private static void printArray(Person[] arr) {
        for (Person person : arr) {
            System.out.println(person);
        }
        System.out.println("-------------------------------");
    }
}
```



## 006.练习1

```java
package com.lxgzhw.demo05.Practice01;

public class Demo {
    public static void main(String[] args) {
        //练习1
        //使用lambda表达式简写接口实现方法
        //接口参数方法
        invokeCook(() -> System.out.println("做饭"));
    }

    private static void invokeCook(Cook cook) {
        cook.cookAMeal();
    }
}
```



## 007.练习2

> 接口

```java
package com.lxgzhw.demo06.Practice02;

public interface Calculator {
    int calc(int a,int b);
}
```

> 测试

```java
package com.lxgzhw.demo06.Practice02;

public class Demo01 {
    public static void main(String[] args) {
        invokeClac(222, 333, (a, b) -> a + b);
    }

    private static void invokeClac(int a, int b, Calculator c) {
        int sum = c.calc(a, b);
        System.out.println("和是:" + sum);
        System.out.println("-------------------------------");
    }
}
```

> 总结

- 当接口作为参数传递的时候,其实现方法可以用`Lambda`表达式简写