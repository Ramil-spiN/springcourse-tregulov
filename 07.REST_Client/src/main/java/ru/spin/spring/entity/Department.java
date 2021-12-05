package ru.spin.spring.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Department {
    private int id;
    private String name;

    public Department() {
    }

    public Department(int id) {
        this.id = id;
    }
        public Department(String name) {
        this.name = name;
    }

    public Department(String name, int maxSalary, int minSalary) {
        this.name = name;
    }
}
