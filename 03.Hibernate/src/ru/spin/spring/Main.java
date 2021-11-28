package ru.spin.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.spin.spring.config.SpringConfig;
import ru.spin.spring.dao.DepartmentDAO;
import ru.spin.spring.dao.EmployeeDAO;
import ru.spin.spring.dao.SectionDAO;
import ru.spin.spring.entity.Department;
import ru.spin.spring.entity.Detail;
import ru.spin.spring.entity.Employee;
import ru.spin.spring.entity.Section;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        EmployeeDAO employeeDAO = context.getBean("employeeDAO", EmployeeDAO.class);
        DepartmentDAO departmentDAO = context.getBean("departmentDAO", DepartmentDAO.class);
        SectionDAO sectionDAO = context.getBean("sectionDAO", SectionDAO.class);

        Employee employee1 = new Employee("Mister", "Tom", 950);
        employee1.setEmployeeDetail(new Detail("Rostov-on-Don", "123", "tom@yandex.ru"));
        Employee employee2 = new Employee("Mister", "Bracho", 750);
        employee2.setEmployeeDetail(new Detail("Rostov-on-Don", "456", "gun@yandex.ru"));

        Department department = new Department("Arhitecture", 300, 1500);
        department.addEmployeeToDepartment(employee1);
        department.addEmployeeToDepartment(employee2);
        departmentDAO.addDepartmentWithEmployees(department);

        Section section = new Section("Chess");
//        Section section2 = new Section("Poker");
        section.addEmployeeToSection(employee1);
        section.addEmployeeToSection(employee2);
//        employee2.addSectionToEmployee(section1);
//        employee2.addSectionToEmployee(section2);
//        sectionDAO.addSectionWithEmployees(section);
        employeeDAO.saveObject(section);

//        departmentDAO.getDepartmentById(5);

//        Employee employee = employeeDAO.addEmployee(
//                new Employee("Mister", "Tom", "Architecture", 950),
//                new Detail("Rostov-on-Don", "123", "tom@yandex.ru"));

//        employeeDAO.getEmployeeById(employee.getId());
//        employeeDAO.getEmployeeById(64);
//        employeeDAO.getEmployees();
//        employeeDAO.getEmployeesByCondition("surname like '%Gun%' and salary >= 900");
//
//        //employeeDAO.updateEmployeeSalaryById(6, 1200);
//        employeeDAO.updateEmployeesByCondition("set salary = salary + 1 where surname like '%Gun%'");
//        employeeDAO.getEmployeesByCondition("surname like '%Gun%'");
//
//        employeeDAO.deleteEmployeeById(58);
//        employeeDAO.deleteEmployeesByCondition("salary > 1000");
    }
}
