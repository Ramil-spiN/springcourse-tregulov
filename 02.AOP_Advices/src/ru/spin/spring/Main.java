package ru.spin.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.spin.spring.config.SpringConfig;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        University university = context.getBean("universityBean", University.class);
        university.setStudents();
        try {
            List<Student> students = university.getStudents();
            System.out.println(students);
        } catch(Exception e) {
            System.out.println("Exception caught --> " + e);
        }

        //students.get(100);

        context.close();
    }
}
