package ru.spin.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ru.spin.spring.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
    @Pointcut("execution(* getStudents())")
    private void getStudents() {}

    @Before("getStudents()")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("Log - before getStudents");
    }

    @AfterReturning(pointcut = "getStudents()", returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) { //output target method
        for (Student student : students) {
            student.setName(student.getName() + " updated name");
            student.setAvgGrade(student.getAvgGrade() + 1);
        }
        System.out.println("Log - after returning getStudents");
    }

    @AfterThrowing(pointcut = "getStudents()", throwing = "exception")
    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {
        System.out.println("Log - throw exception -->   " + exception);
    }

    @After("getStudents()")
    public void afterGetStudentsLoggingAdvice() {
        System.out.println("Log - after getStudents");
    }

    @Around("getStudents()")
    public Object aroundGetStudentsLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object targetMethodResult = null;
        long start = System.currentTimeMillis();
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch(Exception e) {
            System.out.println("Exception caught in Around Advice");
            targetMethodResult = new ArrayList<>(Arrays.asList(new Student("Around Exception", 0, 0)));
            //throw e; //Пробрасываем исключение дальше
        }
        long end = System.currentTimeMillis();
        System.out.println("Log - around getStudents in " + (end - start) + " milliseconds");
        //targetMethodResult = new ArrayList<>(Arrays.asList(new Student("Around Change", 1, 8.3)));
        //Можно поменять результат вывода
        return targetMethodResult;
    }
}
