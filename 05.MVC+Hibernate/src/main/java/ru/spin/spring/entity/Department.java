package ru.spin.spring.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
@ToString
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
//    @Column(name = "max_salary")
//    private int maxSalary;
//    @Column(name = "min_salary")
//    private int minSalary;

//    @OneToMany(mappedBy = "department",
//            cascade = {CascadeType.ALL})
//    private List<Employee> employees;

    public Department() {
    }

    public Department(int id) {
        this.id = id;
    }
        public Department(String name) {
        this.name = name;
    }

//    public Department(String name, int maxSalary, int minSalary) {
//        this.name = name;
//        this.maxSalary = maxSalary;
//        this.minSalary = minSalary;
//    }

//    public void addEmployeeToDepartment(Employee employee) {
//        if (employees == null) {
//            employees = new ArrayList<>();
//        }
//        employees.add(employee);
//        employee.setDepartment(this);
//    }
}
