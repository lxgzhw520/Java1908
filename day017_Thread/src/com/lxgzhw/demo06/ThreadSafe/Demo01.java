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


