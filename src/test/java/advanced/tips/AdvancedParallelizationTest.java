package advanced.tips;

import org.junit.jupiter.api.Test;

public class AdvancedParallelizationTest {
    @Test
    public void test1a()
    {
        //Get the thread name and dynamically fetch method name
        System.out.println(Thread.currentThread().getName()+
                "=>" + new Throwable().getStackTrace()[0].getMethodName());
    }
    @Test
    public void test1b()
    {
        //Get the thread name and dynamically fetch method name
        System.out.println(Thread.currentThread().getName()+
                "=>" + new Throwable().getStackTrace()[0].getMethodName());
    }
    @Test
    public void test1c()
    {
        //Get the thread name and dynamically fetch method name
        System.out.println(Thread.currentThread().getName()+
                "=>" + new Throwable().getStackTrace()[0].getMethodName());
    }
}
