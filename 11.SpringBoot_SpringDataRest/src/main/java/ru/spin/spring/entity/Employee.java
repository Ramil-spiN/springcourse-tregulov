package ru.spin.spring.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "salary")
    private int salary;

//    @ManyToOne
//    @JoinColumn(name = "department_id")
//    private Department department;

//    public Employee() {}
//
//    public Employee(String name, String surname, int salary) {
//        this.name = name;
//        this.surname = surname;
//        this.salary = salary;
//    }

//    public Optional<Department> getOptionalDepartment() {
//        return Optional.ofNullable(department);
//    }

   /* public Department getDepartment() {
//        return getOptionalDepartment().orElse(new Department("none", 0, 0));
        return Optional.ofNullable(department).orElse(new Department("none"));
    }*/
}
