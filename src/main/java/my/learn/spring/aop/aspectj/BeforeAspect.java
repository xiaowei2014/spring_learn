package my.learn.spring.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by 张小伟 on 2015/12/5.
 */
@Aspect
public class BeforeAspect {

    @Before("execution(* greetTo(..))")
    public void beforeGreeting(){
        System.out.println("AspectJ BeforeAdvisor");
    }
}
