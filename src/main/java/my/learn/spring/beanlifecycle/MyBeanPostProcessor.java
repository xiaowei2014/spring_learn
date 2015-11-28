package my.learn.spring.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by ’≈–°Œ∞ on 2015/11/21.
 */
public class MyBeanPostProcessor implements BeanPostProcessor{
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("beanLifeCycle".equals(beanName)){
            System.out.println("BeanPostProcessor.postProcessBeforeInitialization()");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("beanLifeCycle".equals(beanName)){
            System.out.println("BeanPostProcessor.postProcessAfterInitialization()");
        }
        return bean;
    }
}
