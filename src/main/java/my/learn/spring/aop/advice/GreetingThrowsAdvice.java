package my.learn.spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Desc:
 * ------------------------------------
 * Author:zhangxiaowei03@meituan.com
 * Date:15/12/1
 * Time:上午9:17
 */
public class GreetingThrowsAdvice implements ThrowsAdvice{
    public void afterThrowing(Method method,Object[] args,Object target,Exception e){
        System.out.println("-------------");
        System.out.println("method:" + method.getName());
        System.out.println("抛出异常：" + e.getMessage());
        System.out.println("异常处理结束");
    }
}
