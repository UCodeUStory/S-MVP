package com.wangpos.s_mvp.aop;

import android.util.Log;

import com.wangpos.s_mvp.BuildConfig;
import com.wangpos.s_mvp.base.util.LogUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.concurrent.TimeUnit;

/**
 * Created by qiyue on 2018/3/6.
 */
@Aspect
public class TryCatchAspect {

    private static final String TAG = "TryCatch";


    @Pointcut("execution(@com.example.aspectj.TryException * *(..))")//方法切入点
    public void methodAnnotated() {
    }

    @Pointcut("execution(@com.example.aspectj.TryException *.new(..))")//构造器切入点
    public void constructorAnnotated() {
    }

    @Around("methodAnnotated() || constructorAnnotated()")//在连接点进行方法替换
    public Object aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
                MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
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

        }catch (Exception e){
            e.printStackTrace();
            Log.i(TAG,"e"+e.toString());
        }

        return null;
    }
}
