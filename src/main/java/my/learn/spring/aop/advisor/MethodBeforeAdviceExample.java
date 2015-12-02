package my.learn.spring.aop.advisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by 张小伟 on 2015/12/2.
 */
public class MethodBeforeAdviceExample implements MethodBeforeAdvice{
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + "." + method.getName());
        String clientName = (String) args[0];
        System.out.println("How are you! Mr." + clientName + ".");
    }
}
