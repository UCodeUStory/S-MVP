package com.wangpos.s_mvp.aop;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


/**
 * Created by qiyue
 * 通过CheckLogin注解检查用户是否登陆注解，通过aop切片的方式在编译期间织入源代码中
 * 功能：检查用户是否登陆，未登录则提示登录，不会执行下面的逻辑
 */
@Aspect
public class CheckLoginAspect {

    @Pointcut("execution(@com.app.annotation.aspect.CheckLogin * *(..))")//方法切入点
    public void methodAnnotated() {
    }

    @Around("methodAnnotated()")//在连接点进行方法替换
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
//        if (null == SpUtil.getUser()) {
//            Snackbar.make(App.getAppContext().getCurActivity().getWindow().getDecorView(), "请先登录!", Snackbar.LENGTH_LONG)
//                    .setAction("登录", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            TRouter.go(C.LOGIN);
//                        }
//                    }).show();
//            return;
//        }
        joinPoint.proceed();//执行原方法
    }
}

