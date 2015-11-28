package my.learn.spring.beanfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ’≈–°Œ∞ on 2015/11/21.
 */
@Configuration
public class AnnotationConfigApplicationContextExample {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("my.learn.spring");
       Object obj =  ctx.getBean("annotationConfigApplicationContextExample");
        System.out.println(obj);
    }
}
