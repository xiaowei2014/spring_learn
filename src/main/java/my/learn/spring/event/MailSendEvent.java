package my.learn.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * Created by 张小伟 on 2015/11/29.
 */
public class MailSendEvent extends ApplicationContextEvent{

    private String to;


    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     */
    public MailSendEvent(ApplicationContext source,String to) {
        super(source);
        this.to = to;
    }
    public String getTo(){
        return to;
    }
}
