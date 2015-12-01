package my.learn.spring.aop.advice;

import my.learn.spring.aop.monitor.Monitorable;
import my.learn.spring.aop.monitor.PerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Desc:
 * ------------------------------------
 * Author:zhangxiaowei03@meituan.com
 * Date:15/12/1
 * Time:上午9:45
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable{

    private ThreadLocal<Boolean> monitorStatusMap = new ThreadLocal<Boolean>();

    public void setMonitorActive(boolean active) {
        monitorStatusMap.set(active);
    }

    @Override public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj = null;
        if (monitorStatusMap.get() != null && monitorStatusMap.get()){
            PerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
            obj = super.invoke(mi);
            PerformanceMonitor.end();
        }else {
            obj = super.invoke(mi);
        }

        return obj;
    }
}
