package ru.spin.spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("universityBean")
public class University {
    private List<Student> students = new ArrayList<>();

    public void setStudents() {
        Student student1 = new Student("Mister Tom", 5, 9.1);
        Student student2 = new Student("Mister Gun", 4, 8.3);
        Student student3 = new Student("Mister Bracho", 3, 7.9);
        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    public List<Student> getStudents() {
        System.out.println("Information about students:");
        System.out.println(students);
        //students.get(100); // Для срабатывания исключения
        return students;
    }
}
