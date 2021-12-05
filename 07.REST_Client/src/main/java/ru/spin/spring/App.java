package ru.spin.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.spin.spring.config.SpringConfig;
import ru.spin.spring.entity.Department;
import ru.spin.spring.entity.Employee;

import java.util.List;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

        List<Employee> employees = communication.getAllEmployees();
        System.out.println(employees);

        Employee employee = communication.getEmployee(56);
        System.out.println(employee);

        employee = new Employee("Justin", "Bieber", 600);
        employee.setId(160);
        communication.saveEmployee(employee);

        communication.deleteEmployee(158);
    }
}
