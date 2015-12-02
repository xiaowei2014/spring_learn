package my.learn.spring.aop.advisor;

/**
 * Created by 张小伟 on 2015/12/2.
 */
public class Waiter {
    public void greetTo(String name){
        System.out.println("waiter greet to " + name + "...");
    }

    public void serveTo(String name){
        System.out.println("waiter serving " + name + "...");
    }
}
