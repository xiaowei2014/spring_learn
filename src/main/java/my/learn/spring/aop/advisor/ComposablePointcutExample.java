package my.learn.spring.aop.advisor;

import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * Desc:
 * ------------------------------------
 * Author:zhangxiaowei03@meituan.com
 * Date:15/12/4
 * Time:上午9:23
 */
public class ComposablePointcutExample {
    public Pointcut getIntersectionPointcut(){
        ComposablePointcut pointcut = new ComposablePointcut();
        Pointcut controlFlowPointcut = new ControlFlowPointcut(WaiterDelegate.class,"service");
        NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
        nameMatchMethodPointcut.setMappedName("greetTo");
        return pointcut.intersection(controlFlowPointcut).intersection((MethodMatcher)nameMatchMethodPointcut);
    }
}
