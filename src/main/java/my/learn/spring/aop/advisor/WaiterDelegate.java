package my.learn.spring.aop.advisor;

/**
 * Desc:
 * ------------------------------------
 * Author:zhangxiaowei03@meituan.com
 * Date:15/12/4
 * Time:上午8:56
 */
public class WaiterDelegate {
    private Waiter waiter;

    public void service(String clientName){
        waiter.greetTo(clientName);
        waiter.serveTo(clientName);
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
