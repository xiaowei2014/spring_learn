package my.learn.spring.aop.proxy;

import my.learn.spring.aop.monitor.ForumService;
import my.learn.spring.aop.monitor.ForumServiceImpl;

import java.lang.reflect.Proxy;

/**
 * Desc:
 * ------------------------------------
 * Author:zhangxiaowei03@meituan.com
 * Date:15/11/30
 * Time:上午9:57
 */
public class TestForumService {
    public static void main(String[] args) {
        ForumService target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);

        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                handler);

        proxy.removeForum(1);
        proxy.removeTopic(1);

    }
}
