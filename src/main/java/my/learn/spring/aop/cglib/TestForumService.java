package my.learn.spring.aop.cglib;

import my.learn.spring.aop.ForumServiceImpl;

/**
 * Desc:
 * ------------------------------------
 * Author:zhangxiaowei03@meituan.com
 * Date:15/11/30
 * Time:上午10:26
 */
public class TestForumService {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeTopic(1);
        forumService.removeForum(1);
    }
}
