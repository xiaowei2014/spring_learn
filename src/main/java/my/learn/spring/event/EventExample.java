package my.learn.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 张小伟 on 2015/11/29.
 */
public class EventExample {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MailSender mailSender = ctx.getBean("mailSender", MailSender.class);
        mailSender.sendMail("aaa@bbb.com");
    }
}
