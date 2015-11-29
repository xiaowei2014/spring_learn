package my.learn.spring.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by 张小伟 on 2015/11/28.
 */
@Configuration
public class ServiceConfig {

    @Autowired
    private DaoConfig daoConfig;

    @Bean
    @Scope("prototype")
    public LogonService logonService(){
        LogonService logonService = new LogonService();
        logonService.setLogDao(daoConfig.logDao());
        logonService.setUserDao(daoConfig.userDao());
        return logonService;
    }

    private class LogonService{
        public void setLogDao(DaoConfig.LogDao logDao){}
        public void setUserDao(DaoConfig.UserDao userDao){}
    }
}
