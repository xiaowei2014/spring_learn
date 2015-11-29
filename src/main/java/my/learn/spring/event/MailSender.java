package my.learn.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by 张小伟 on 2015/11/29.
 */
@Component
public class MailSender implements ApplicationContextAware{

    private ApplicationContext ctx;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void sendMail(String to){
        System.out.println("MailSender:模拟发送邮件...");
        MailSendEvent mse = new MailSendEvent(this.ctx,to);
        ctx.publishEvent(mse);
    }
}
