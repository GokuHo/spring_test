package annotation_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Aspect
@Component
@Order(0)
public class AOPAspect {

    @Pointcut(value = "execution(* annotation_aop.*.*(..))")
    public void myPointcut(){};

    @Before("myPointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature + " -> before advice");
    }

    @AfterReturning(value = "myPointcut()", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature + " -> after returning advice -> " + result);
    }

    @Around("myPointcut()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();

        System.out.println(signature + " -> around before advice");
        Object result = proceedingJoinPoint.proceed();
        System.out.println(signature + " -> around after advice -> " + result);
    }

    @AfterThrowing(value = "myPointcut()", throwing = "throwable")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable throwable) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature + " -> after throwing advice -> " + throwable);
    }

    @After("myPointcut()")
    public void afterAdvice(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature + " -> after advice");
    }
}
