package my.learn.spring.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by 张小伟 on 2015/11/21.
 */
public class BeanLifeCycle implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{
    private BeanFactory beanFactory;
    private String beanName;

    public BeanLifeCycle(){
        System.out.println("构造函数");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("BeanFactoryAware.setBeanFactory()");
    }

    public void setBeanName(String name) {
        this.beanName=name;
        System.out.println("BeanNameAware.setBeanName()");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet()");
    }

    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy()");
    }

    public void myInit(){
        System.out.println("init-method");
    }

    public void myDestroy(){
        System.out.println("destroy-method");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy()");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct()");
    }
}
