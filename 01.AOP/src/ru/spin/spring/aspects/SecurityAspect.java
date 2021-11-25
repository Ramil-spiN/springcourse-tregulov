package ru.spin.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(20)
public class SecurityAspect {
    @Before("Pointcuts.allGetPublic()")
    public void beforeGetPublicSecurityAdvice() {
        System.out.println("#Security get");
    }

    @Before("Pointcuts.allAddPublic()")
    public void beforeAddPublicSecurityAdvice() {
        System.out.println("#Security add");
    }
}
