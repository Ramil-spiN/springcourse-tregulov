package ru.spin.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {
//    @Before("execution(public void getBook(..))")
// Для всех методов с таким наименованием и с любыми параметрами (или без параметров)
//    @Before("execution(public void getBook(String, ru.spin.spring.Book, ..))")
// Любые параметры после конретных
    @Before("execution(public void ru.spin.spring.libraries.UniversityLibrary.getBook(String, ru.spin.spring.Book))")
    public void beforeGetLoggingAdvise() {
        System.out.println("beforeGetBookAdvise - try to take a book");
    }

    //@Before("execution(* *(..))") //Для всех методов
    //@Before("execution(* *(*))") //(*) - один любой параметр
    @Before("execution(* return*())") //Метод return*() без параметров
    //Обязательные параметры - возвращаемое значение и имя метода (* - любое значение или имя)
    public void beforeReturnAdvise() {
        System.out.println("beforeReturnAdvise - try to return anything");
    }



    //Объявление pointcut
    @Pointcut("execution(* getB*(..))")
    private void allGetBMethods() {} //Пустой метод, чтобы он ссылался на поинткат

    @Pointcut("execution(* add*(..))")
    private void allAddMethods() {}

    @Pointcut("allGetBMethods() || allAddMethods()")
    private void allGetAndAddMethods() {}

    @Before("allGetAndAddMethods() || execution(* return*())") //Ссылка на поинткат(ы)
    public void beforeGetSecurityAdvise() {
        System.out.println("beforeGetSecurityAdvise - rights check");
    }


    @Pointcut("execution(* ru.spin.spring.libraries.UniversityLibrary.*(..)) && " +
             "!execution(* ru.spin.spring.libraries.UniversityLibrary.add*(..))")
    private void allMethodsExceptAssFromUniversityLibrary() {}

    @Before("allMethodsExceptAssFromUniversityLibrary()")
    public void beforeUniversityMethodsAdvise() {
        System.out.println("Log without add");
    }
}
