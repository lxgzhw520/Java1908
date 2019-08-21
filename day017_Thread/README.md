# `day017` 线程

> 作者: 张大鹏

## 001.获取线程名字

> `Thread`继承类

```java
package com.lxgzhw.demo01;

/*
获取线程的名称:
    1.使用Thread类中的getName()方法
    2.先获取正在执行的线程,再通过该线程获取名称
        currentThread()
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        //重写run方法
        System.out.println("当前线程的名称:"
                + Thread.currentThread().getName());
    }
}
```

> 测试类

```java
package com.lxgzhw.demo01;

public class getName {
    public static void main(String[] args) {
        //1.获取Thread的子类对象
        MyThread myThread = new MyThread();
        //2.调用start方法,开启新线程,执行run方法
        myThread.start();

        System.out.println("-------------------------------");
        //匿名调用
        new MyThread().start();
        new MyThread().start();
        System.out.println("-------------------------------");
        System.out.println(Thread.currentThread().getName());

    }
}
```



## 002.设置线程的名字

> `Thread`继承类

```java
package com.lxgzhw.demo02.setName;
/*
设置线程的名称:
    1.setName
    2.构造方法
 */
public class MyThread extends Thread {
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("当前线程的名字:"+Thread.currentThread().getName());
    }
}
```

> 测试类

```java
package com.lxgzhw.demo02.setName;
/*
设置线程的名称:
    1.setName
    2.构造方法
 */
public class MyThread extends Thread {
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("当前线程的名字:"+Thread.currentThread().getName());
    }
}
```



## 003.线程休眠

```java
package com.lxgzhw.demo03.sleep;

public class Demo {
    public static void main(String[] args) {
        //模拟秒表
        for (int i = 0; i < 60; i++) {
            System.out.println(i);
            //使用Thread类的sleep方法让程序睡眠1秒钟
            try {
                Thread.sleep( 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```



## 004.匿名内部类实现多线程

```java
package com.lxgzhw.demo05.innerClass;

public class Demo01 {
    public static void main(String[] args) {
        //注意:主线程优先执行,所以分割线打印会提前
        //匿名内部类实现多线程的创建
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("当前线程名称:" + Thread.currentThread().getName());
                }
            }
        }.start();
        //使用接口
        System.out.println("-------------------------------");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("当前线程:" + Thread.currentThread().getName());
                }
            }
        }).start();
    }
}
```



## 005.线程安全问题的出现

> 接口实现类

```java
package com.lxgzhw.demo06.ThreadSafe;

public class RunnableImpl implements Runnable {
    private int ticket = 100;
    Object obj = new Object();

    //设置线程任务
    @Override
    public void run() {
        while (ticket > 0) {
            //同步代码块,解决线程安全问题
            System.out.println(Thread.currentThread().getName() + "正在卖票" + ticket);
            ticket--;
        }
    }

}
```

> 测试类

```java
import com.lxgzhw.demo06.ThreadSafe.RunnableImpl;

public class Demo01 {
    public static void main(String[] args) {
        //创建接口实现类
        RunnableImpl runnable = new RunnableImpl();
        //创建线程
        Thread thread01 = new Thread(runnable);
        Thread thread02 = new Thread(runnable);
        Thread thread03 = new Thread(runnable);
        //开启多线程
        thread01.start();
        thread02.start();
        thread03.start();

    }
}
```



## 006.解决线程安全方法1

> 接口实现类

```java
package com.lxgzhw.demo07.Synchronized;

/*
实现Runnable接口创建多线程程序的好处:
    1.避免了单继承的局限性
        一个类只能继承一个类,类继承了Thread类就不能继承其他的类
        实现了Runnable接口,还可以继承其他的类,实现其他的接口
    2.增强了程序的扩展性,降低了程序的耦合性(解耦)
        实现Runnable接口的方式,把设置线程任务和开启新线程进行了分离(解耦)
        实现类中,重写了run方法:用来设置线程任务
        创建Thread类对象,调用start方法:用来开启新线程
 */
public class RunnableImpl implements Runnable {
    //卖票案例:3个卖票人员同时卖票
    //定义一个多线程共享的票源
    private int ticket = 1000;
    //创建一个锁对象
    Object obj = new Object();

    //设置线程任务
    @Override
    public void run() {
        while (true) {
            if (ticket > 2) {
                //同步代码块,解决线程安全问题的方法1
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + "正在卖票:" + ticket);
                    ticket--;
                }
            }else {
                break;
            }
        }
    }
}
```

> 测试类

```java
package com.lxgzhw.demo07.Synchronized;

public class Demo {
    public static void main(String[] args) {
        //创建接口实现类对象
        RunnableImpl runnable = new RunnableImpl();
        //创建3个线程同时卖票
        Thread thread01 = new Thread(runnable);
        Thread thread02 = new Thread(runnable);
        Thread thread03 = new Thread(runnable);
        //开启多线程
        thread01.start();
        thread02.start();
        thread03.start();
    }
}
```



## 007.加锁

> 接口实现类

```java
package com.lxgzhw.demo08.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl implements Runnable {
    private int ticket = 10000;
    //多态方法创建锁
    Lock l = new ReentrantLock();

    @Override
    public void run() {
        //解决线程安全问题的方案2  锁
        //最通用方法方法 必须记住
        //需要根据线程数量来判断大于多少
        while (true) {
            //判断必须写在无限循环内部
            //写在外部会出现访问不存在资源问题
            if (ticket > 3) {
                //上锁
                l.lock();

                //中间过程被安全的锁住
                System.out.println(Thread.currentThread().getName() + "" +
                        "正在卖票:" + ticket);
                ticket--;

                //解锁
                l.unlock();
            } else {
                break;
            }
        }
    }
}
```

> 测试类

```java
package com.lxgzhw.demo08.Lock;

public class Demo {
    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
```



## 008.等待和唤醒

```java
package com.lxgzhw.demo09.Wait;

public class Demo01 {
    public static void main(String[] args) {
        //唤醒线程
        //创建锁对象,保证唯一
        final Object obj = new Object();

        //创建一个顾客线程
        new Thread() {
            @Override
            public void run() {
                //一直等着买包子
                while (true) {
                    //保证等待和唤醒的线程只有一个执行
                    //同步技术
                    synchronized (obj) {
                        System.out.println("顾客1在消费");
                        //调用wait方法
                        //放弃cpu的执行
                        //进入到waiting状态
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("包子做好了,顾客1开始吃");
                        System.out.println("-------------------------------");
                    }
                    System.out.println("顾客1吃完了");
                    break;
                }
            }
        }.start();

        //创建另一个顾客线程
        new Thread() {
            @Override
            public void run() {
                //顾客2能吃两份包子
                int count = 0;
                //一直等着买包子
                while (true) {
                    //保证等待和唤醒的线程只有一个执行
                    //同步技术
                    synchronized (obj) {
                        System.out.println("顾客2在消费");
                        //调用wait方法
                        //放弃cpu的执行
                        //进入到waiting状态
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("包子做好了,顾客2开始吃");
                        System.out.println("-------------------------------");
                    }
                    if (count > 2) {
                        System.out.println("顾客2吃了两份包子,吃饱了,走了");
                        break;
                    }
                    count++;
                }
            }
        }.start();

        //创建老板线程
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    //花了1秒钟做包子
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj) {
                        System.out.println("老板把包子做好了");
                        //obj.notify();//随机唤醒一个
                        //唤醒全部
                        obj.notifyAll();
                    }
                }
            }
        }.start();

    }
}
```

