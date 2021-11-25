package ru.spin.spring.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* getB*(..))")
    public void allGetPublic() {}

    @Pointcut("execution(* add*(..))")
    public void allAddPublic() {}
}
