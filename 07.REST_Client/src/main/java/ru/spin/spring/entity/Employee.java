package ru.spin.spring.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {
    private int id;
    private String name;
    private String surname;
    private int salary;

//    private Department department;

    public Employee() {}

    public Employee(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

//    public Employee(String name, String surname, int salary, Department department) {
//        this.name = name;
//        this.surname = surname;
//        this.salary = salary;
//        this.department = department;
//    }
}
