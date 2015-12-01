package my.learn.spring.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by 张小伟 on 2015/11/30.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice{

    public void before(Method method, Object[] args, Object target) throws Throwable {
        if (!(args.length > 0 && args[0] instanceof String)){return;}
        String clientName = (String) args[0];
        System.out.println("BeforeAdvice : How are you! Mr." + clientName + ".");
    }
}
