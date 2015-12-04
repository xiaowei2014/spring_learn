package my.learn.spring.aop.advisor;

import my.learn.spring.aop.monitor.Monitorable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 张小伟 on 2015/12/3.
 */
public class AdvisorExample {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println("StaticMethodMatcherPointcutAdvisor");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");
        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");

        System.out.println("\nRegexpMethodPointcutAdvisor");
        waiter = (Waiter) ctx.getBean("waiter2");
        waiter.greetTo("John");
        waiter.serveTo("John");

        System.out.println("\ncontrolFlowPointcutAdvisorExample");
        waiter = (Waiter) ctx.getBean("waiter4");
        WaiterDelegate waiterDelegate = new WaiterDelegate();
        waiterDelegate.setWaiter(waiter);
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        waiterDelegate.service("Peter");

        System.out.println("\nComposablePointcutAdvisorExample");
        waiter = (Waiter) ctx.getBean("waiter5");
        waiterDelegate.setWaiter(waiter);
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        waiterDelegate.service("Peter");

        System.out.println("\nDefaultIntroductionAdvisor");
        my.learn.spring.aop.advice.Waiter waiter1 = (my.learn.spring.aop.advice.Waiter) ctx.getBean("waiterProxy1");
        waiter1.greetTo("Peter");
        waiter1.serveTo("Peter");

        Monitorable monitorable = (Monitorable) waiter1;
        monitorable.setMonitorActive(true);
        waiter1.greetTo("John");


    }
}
