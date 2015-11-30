package my.learn.spring.aop.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 张小伟 on 2015/11/30.
 */
public class TestBeforeAdvice {
    public static void main(String[] args) {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        ProxyFactory pf = new ProxyFactory();
        pf.setInterfaces(target.getClass().getInterfaces());//动态代理
        pf.setOptimize(true);//启用优化后，使用CGLIB
        pf.setTarget(target);
        pf.addAdvice(advice);
        pf.addAdvice(new GreetingAfterAdvice());
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");

        System.out.println("-----------------------------------");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiterProxy");
        waiter.greetTo("John");
    }
}
