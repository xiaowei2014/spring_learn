package my.learn.spring.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created by ’≈–°Œ∞ on 2015/11/21
 */
public class BeanFactoryExample {
    public static void main(String[] args) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
       Object bean =  factory.getBean("applicationContextExample");
        System.out.println(bean);
    }
}
