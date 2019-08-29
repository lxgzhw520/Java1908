import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Demo {

    @Before
    public void befor() {
        System.out.println("test之前执行");
    }

    @Test
    public void show() {
        System.out.println("test方法");
    }

    @After
    public void after() {
        System.out.println("test之后执行");
    }
}
