package my.learn.spring.aop;

/**
 * Desc:
 * ------------------------------------
 * Author:zhangxiaowei03@meituan.com
 * Date:15/11/30
 * Time:上午10:01
 */
public class PerformanceMonitor {

    private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<MethodPerformance>();

    public static void begin(String method){
        System.out.println("begin monitor ...");
        MethodPerformance mp = new MethodPerformance(method);
        performanceRecord.set(mp);
    }

    public static void end(){
        System.out.println("end monitor ...");
        MethodPerformance mp = performanceRecord.get();
        mp.printPerformance();
    }

}
