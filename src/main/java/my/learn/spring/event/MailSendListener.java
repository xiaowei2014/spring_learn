package my.learn.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by 张小伟 on 2015/11/29.
 */
@Component
public class MailSendListener implements ApplicationListener<MailSendEvent>{
    public void onApplicationEvent(MailSendEvent event) {
        System.out.println("MailSendListner:向" + event.getTo() + "发送完一封邮件");
    }
}
