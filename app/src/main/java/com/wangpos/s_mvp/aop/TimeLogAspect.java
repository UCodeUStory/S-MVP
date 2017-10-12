package com.wangpos.s_mvp.aop;





import com.wangpos.s_mvp.BuildConfig;
import com.wangpos.s_mvp.base.util.LogUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.concurrent.TimeUnit;

/**
 * 根据注解TimeLog自动添加打印方法耗代码，通过aop切片的方式在编译期间织入源代码中
 * 功能：自动打印方法的耗时
 *
 * 在需要计算时间的方法上添加 @TimeLog即可
 */
@Aspect
public class TimeLogAspect {

    private static final String TAG = "time";

    private boolean isStarted = BuildConfig.isTime;
    @Pointcut("execution(@com.example.aspectj.TimeLog * *(..))")//方法切入点
    public void methodAnnotated() {
    }

    @Pointcut("execution(@com.example.aspectj.TimeLog *.new(..))")//构造器切入点
    public void constructorAnnotated() {
    }

    @Around("methodAnnotated() || constructorAnnotated()")//在连接点进行方法替换
    public Object aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        if (isStarted) {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        LogUtils.showLog("TimeLog getDeclaringClass", methodSignature.getMethod().getDeclaringClass().getCanonicalName());
            String className = methodSignature.getDeclaringType().getSimpleName();
            String methodName = methodSignature.getName();
            long startTime = System.nanoTime();

            Object result = joinPoint.proceed();//执行原方法

            StringBuilder keyBuilder = new StringBuilder();
            keyBuilder.append(methodName + ":");
            for (Object obj : joinPoint.getArgs()) {
                if (obj instanceof String) keyBuilder.append((String) obj);
                else if (obj instanceof Class) keyBuilder.append(((Class) obj).getSimpleName());
            }
            String key = keyBuilder.toString();
            LogUtils.i(TAG, (className + "." + key + joinPoint.getArgs().toString() + " =》》:" + "[" + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime)) + "ms]"));
            //LogUtils.showLog("TimeLog", (className + "." + key + joinPoint.getArgs().toString() + " =》》:" + "[" + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime)) + "ms]"));// 打印时间差
            return result;
        }else{
            Object result = joinPoint.proceed();//执行原方法
            return result;
        }
    }
}