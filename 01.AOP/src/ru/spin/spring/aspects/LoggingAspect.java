package ru.spin.spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.spin.spring.Book;

@Component
@Aspect
@Order(10)
public class LoggingAspect {
    @Before("Pointcuts.allGetPublic()")
    public void beforeGetPublicLoggingAdvice(JoinPoint joinPoint) {
        System.out.println("#Log get");
        System.out.println("@join point - " + joinPoint.getSignature());
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        if (methodSignature.getName().equals("getBook")){
            Object[] args = joinPoint.getArgs();
            for (Object obj : args) {
                if (obj instanceof Book) {
                    System.out.println("-> Book name '" + ((Book) obj).getName() + "'");
                } else if (obj instanceof String) {
                    System.out.println("-> Book reader '" + obj.toString() + "'");
                }
            }
        }
    }

    @Before("Pointcuts.allAddPublic()")
    public void beforeAddPublicLoggingAdvice(JoinPoint joinPoint) {
        System.out.println("#Log add");
    }
}
