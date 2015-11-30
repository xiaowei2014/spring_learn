package my.learn.spring.aop.advice;

/**
 * Created by 张小伟 on 2015/11/30.
 */
public class NaiveWaiter implements Waiter{
    public void greetTo(String name) {
        System.out.println("greet to " + name + "...");
    }

    public void serveTo(String name) {
        System.out.println("serving " + name + "...");
    }
}
