package my.learn.spring.beanlifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by ��Сΰ on 2015/11/21.
 */
public class BeanLifeCycleExample {
    public static void main(String[] args) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        ConfigurableBeanFactory cbf = (ConfigurableBeanFactory) factory;
        cbf.addBeanPostProcessor(new MyBeanPostProcessor());
        cbf.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        InitDestroyAnnotationBeanPostProcessor annotationBeanPostProcessor = new InitDestroyAnnotationBeanPostProcessor();
        annotationBeanPostProcessor.setDestroyAnnotationType(PreDestroy.class);
        annotationBeanPostProcessor.setInitAnnotationType(PostConstruct.class);
        cbf.addBeanPostProcessor(annotationBeanPostProcessor);


        System.out.println("第一次调用");
        BeanLifeCycle beanLifeCycle = cbf.getBean("beanLifeCycle",BeanLifeCycle.class);
        System.out.println("第二次调用");
        beanLifeCycle = cbf.getBean("beanLifeCycle",BeanLifeCycle.class);
        cbf.destroySingletons();

    }
}
