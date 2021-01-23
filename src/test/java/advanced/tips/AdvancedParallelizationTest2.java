package advanced.tips;

import org.junit.jupiter.api.Test;

public class AdvancedParallelizationTest2 {
    @Test
    public void test2a()
    {
        //Get the thread name and dynamically fetch method name
        System.out.println(Thread.currentThread().getName()+
                "=>" + new Throwable().getStackTrace()[0].getMethodName());
    }
    @Test
    public void test2b()
    {
        //Get the thread name and dynamically fetch method name
        System.out.println(Thread.currentThread().getName()+
                "=>" + new Throwable().getStackTrace()[0].getMethodName());
    }
    @Test
    public void test2c()
    {
        //Get the thread name and dynamically fetch method name
        System.out.println(Thread.currentThread().getName()+
                "=>" + new Throwable().getStackTrace()[0].getMethodName());
    }
    @Test
    public void test2d()
    {
        //Get the thread name and dynamically fetch method name
        System.out.println(Thread.currentThread().getName()+
                "=>" + new Throwable().getStackTrace()[0].getMethodName());
    }
    @Test
    public void test2e()
    {
        //Get the thread name and dynamically fetch method name
        System.out.println(Thread.currentThread().getName()+
                "=>" + new Throwable().getStackTrace()[0].getMethodName());
    }
}
