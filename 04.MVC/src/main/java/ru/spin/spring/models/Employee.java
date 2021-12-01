package ru.spin.spring.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.spin.spring.validation.CheckPhone;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class Employee {
    //@NotEmpty(message = "Required field")
    @NotBlank(message = "Symbols required")
    @Size(min = 2, message = "Size is too small")
    private String name;
    private String surname;
    private int salary;
    //@Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "Pattern is xxx-xx-xx")
    @CheckPhone(value = "123", message = "Wrong phone number") //Созданная аннотация
    private String phone;
    private int details_id;
    private int department_id;
    private Map<Integer, String> departmentsMap;
    private int post_id;
    private Map<Integer, String> postsMap;
    //@Size(min = 1)
    private List languages;
    private Map<Integer, String> languagesMap;

    public Employee() {
        departmentsMap = new HashMap<>();
        departmentsMap.put(0, "IT");
        departmentsMap.put(1, "Architecture");

        postsMap = new HashMap<>();
        postsMap.put(0, "Chief");
        postsMap.put(1, "Specialist");

        languagesMap = new HashMap<>();
        languagesMap.put(0, "RU");
        languagesMap.put(1, "EN");
        languagesMap.put(2, "FR");
        languagesMap.put(3, "IT");
    }

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDetails_id() {
        return details_id;
    }

    public void setDetails_id(int details_id) {
        this.details_id = details_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public Map<Integer, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<Integer, String> departments) {
        this.departments = departments;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public Map<Integer, String> getPosts() {
        return posts;
    }

    public void setPosts(Map<Integer, String> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }*/
}
