package my.learn.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 张小伟 on 2015/11/28.
 */
@Configuration
public class DaoConfig {

    @Bean
    public UserDao userDao(){
        return new UserDao();
    }

    @Bean
    public LogDao logDao(){
        return new LogDao();
    }

    public class UserDao{};
    public class LogDao{}
}
