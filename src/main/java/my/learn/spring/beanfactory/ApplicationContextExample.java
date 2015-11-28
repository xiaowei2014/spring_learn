package my.learn.spring.beanfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**:
 * Created by ’≈–°Œ∞ on 2015/11/21.
 */
public class ApplicationContextExample {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Object obj = ctx.getBean("applicationContextExample");
        System.out.println(obj);
    }
}
