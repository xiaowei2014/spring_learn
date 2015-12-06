package my.learn.spring.aop.autoproxy;

import my.learn.spring.aop.advisor.Seller;
import my.learn.spring.aop.advisor.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 张小伟 on 2015/12/5.
 */
public class TestAutoProxy {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        Waiter waiter = (Waiter) ctx.getBean("waiterTarget");
        Object obj = ctx.getBean("waiterTarget");
        System.out.println(obj.getClass());
        Seller seller = (Seller) ctx.getBean("sellerTarget");
//        waiter.greetTo("John");
        seller.greetTo("John");
    }
}
