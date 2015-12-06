package my.learn.spring.aop.aspectj;

import my.learn.spring.aop.advice.NaiveWaiter;
import my.learn.spring.aop.advice.Waiter;
import my.learn.spring.aop.advisor.Seller;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 张小伟 on 2015/12/5.
 */
public class TestAspectJProxy {
    public static void main(String[] args) {
        Waiter waiter = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(waiter);
        factory.addAspect(BeforeAspect.class);
        Waiter proxy = factory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("John");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        proxy = (Waiter) ctx.getBean("naiveWaiter");
        proxy.greetTo("John");
        proxy.serveTo("John");

        System.out.println("\nDeclareParents");
       Seller seller = (Seller) ctx.getBean("sellerTarget");
        seller.greetTo("John");
        Waiter waiter1 = (Waiter) seller;
        waiter1.serveTo("John");
    }
}
