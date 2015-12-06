package my.learn.spring.aop.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by 张小伟 on 2015/12/5.
 */
@Aspect
public class AnnotationAspect {

    @AfterReturning("@annotation(java.lang.Deprecated)")
    public void method(){
        System.out.println("Deprecated method");
    }
}
