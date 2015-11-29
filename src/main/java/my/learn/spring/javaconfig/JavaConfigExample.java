package my.learn.spring.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by 张小伟 on 2015/11/28.
 */
public class JavaConfigExample {
    public static void main(String[] args) {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(DaoConfig.class);
        ctx.register(ServiceConfig.class);
        ctx.refresh();
        DaoConfig.UserDao userDao = ctx.getBean(DaoConfig.UserDao.class);
        System.out.println(userDao);
    }
}
