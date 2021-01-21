package com.ifreedom.freedom.AOPPack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

    //前置增强
    @Before(value = "execution(* com.ifreedom.freedom.servicepack..*(..))")
    public void before(){
        System.out.println("前置增强........");
    }

    //后置增强
    @AfterReturning(value = "execution(* com.ifreedom.freedom.servicepack..*(..))")
    public void after(){
        System.out.println("后置增强........");
    }

    //环绕增强
    @Around(value = "execution(* com.ifreedom.freedom.servicepack..*(..))")
    public void arround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //方法之前执行的代码
        System.out.println("环绕增强 方法之前执行........");

        //执行被增强的方法
        proceedingJoinPoint.proceed();

        //方法之后执行的代码
        System.out.println("环绕增强 方法之后执行........");
    }


//    @Pointcut("execution(* com.ifreedom.freedom.*.*(..))")
//    private void pointcut(){
//        System.out.println("这是pointcut方法");
//    }
//
//    @Around("pointcut()")
//    public Object around(ProceedingJoinPoint point) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object result = point.proceed();
//        long end  = System.currentTimeMillis();
//        System.out.println("消耗的时间是：" + (end -start));
//        return result;
//    }
}
