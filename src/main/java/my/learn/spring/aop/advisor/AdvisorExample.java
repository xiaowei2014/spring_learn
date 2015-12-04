package my.learn.spring.aop.advisor;

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

        System.out.println();
        System.out.println("RegexpMethodPointcutAdvisor");
        waiter = (Waiter) ctx.getBean("waiter2");
        waiter.greetTo("John");
        waiter.serveTo("John");

        System.out.println();
        System.out.println("DynamicMethodMatcherPointcutAdvisor");
        waiter = (Waiter) ctx.getBean("waiter3");
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        waiter.serveTo("John");
        waiter.greetTo("John");
    }
}
