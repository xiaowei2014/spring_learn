package my.learn.spring.aop.aspectj;

import my.learn.spring.aop.advice.NaiveWaiter;
import my.learn.spring.aop.advice.Waiter;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by 张小伟 on 2015/12/5.
 */
@Aspect
public class DeclareParentsAspect {

    @DeclareParents(value = "my.learn.spring.aop.advisor.Seller",defaultImpl = NaiveWaiter.class)
    public Waiter waiter;
}
