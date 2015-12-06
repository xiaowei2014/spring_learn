package my.learn.spring.aop.schema;

import my.learn.spring.aop.advice.NaiveWaiter;
import my.learn.spring.aop.advice.Waiter;
import my.learn.spring.aop.advisor.Seller;
import my.learn.spring.aop.aspectj.BeforeAspect;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 张小伟 on 2015/12/5.
 */
public class TestSchemaAspect {
    public static void main(String[] args) {


        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Waiter proxy = (Waiter) ctx.getBean("naiveWaiter");
        proxy.greetTo("John");
        proxy.serveTo("John");


    }
}
