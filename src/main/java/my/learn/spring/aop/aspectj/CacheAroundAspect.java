package my.learn.spring.aop.aspectj;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Desc:
 * ------------------------------------
 * Author:zhangxiaowei03@meituan.com
 * Date:15/12/31
 * Time:上午9:22
 */
@Aspect public class CacheAroundAspect {

    private LoadingCache<Method, Cache> methodCacheMap = null;

    private Map<String, Object> redisCache = new ConcurrentHashMap<String, Object>();

    private static final String SEPARATOR = "_";

    public CacheAroundAspect() {
        this.methodCacheMap = CacheBuilder.newBuilder().maximumSize(5000).expireAfterWrite(1, TimeUnit.DAYS)
                .build(new CacheLoader<Method, Cache>() {
                    public Cache load(Method method) {
                            return method.getAnnotation(Cache.class);
                    }
                });

    }

    @Around(value = "@annotation(my.learn.spring.aop.aspectj.Cache)") public Object around(ProceedingJoinPoint pjp)
            throws Throwable {

        Signature signature = pjp.getSignature();

        if (!(signature instanceof MethodSignature)) {
            return pjp.proceed();
        }

        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method.isAnnotationPresent(Cache.class)) {
            return invoke(method, pjp);
        }

        Object target = pjp.getTarget();
        Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
        if (targetMethod.isAnnotationPresent(Cache.class)) {
            return invoke(targetMethod, pjp);
        }

        Object result = pjp.proceed();
        return result;

    }

    private Object invoke(Method method, ProceedingJoinPoint pjp) throws Throwable {
        Cache cache = methodCacheMap.get(method);

        String cacheKey = getCacheKey(pjp, cache, method);
        Object redisValue = redisCache.get(cacheKey);
        if (redisValue == null) {
            Object value = pjp.proceed();
            if (value != null) {
                redisCache.put(cacheKey, value);
            }
        }
        return redisValue;
    }

    private String getCacheKey(ProceedingJoinPoint pjp, Cache cache, Method method) {
        //key = 前缀 + 类名 + 方法名 + 参数

        String prefix = cache.prefix();
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();

        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(SEPARATOR).append(className).append(".").append(methodName);

        Object[] args = pjp.getArgs();
        if (args != null) {
            sb.append(SEPARATOR);
            for (Object obj : args) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }
}
