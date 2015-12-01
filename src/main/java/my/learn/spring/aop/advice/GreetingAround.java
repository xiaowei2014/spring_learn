package my.learn.spring.aop.advice;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Desc:
 * ------------------------------------
 * Author:zhangxiaowei03@meituan.com
 * Date:15/12/1
 * Time:上午9:04
 */
public class GreetingAround implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object obj = null;
        Object[] args = invocation.getArguments();
        if (args.length > 0 && args[0] instanceof String){
            String clientName = (String) args[0];
            System.out.println("Around Advice : How are you! Mr." + clientName + ".");
             obj = invocation.proceed();
            System.out.println("Around Advice : please enjoy yourselef !");
        }else {
            obj = invocation.proceed();
        }

        return obj;
    }
}
