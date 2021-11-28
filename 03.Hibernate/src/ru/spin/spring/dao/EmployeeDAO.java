package ru.spin.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.spin.spring.entity.Department;
import ru.spin.spring.entity.Detail;
import ru.spin.spring.entity.Employee;
import ru.spin.spring.entity.Section;

import java.util.List;

@Component("employeeDAO")
public class EmployeeDAO {
    SessionFactory sessionFactory;

    public EmployeeDAO() {
        this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
    }

    public void saveObject(Object o) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(o);
            session.getTransaction().commit();
        }
    }

    public Employee addEmployee(Employee employee, Detail detail) {
        employee.setEmployeeDetail(detail);
//        detail.setEmployee(employee); //Если будем сохранять detail - для Bi-directional отношения

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(employee);
//            session.save(detail);
            session.getTransaction().commit();

            System.out.println(employee);
        }

        return employee;
    }

    public Employee getEmployeeById(int id) {
        Employee employee;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            employee = session.get(Employee.class, id);
            employee.getEmployeeDetail().toString();
            //При Lazy загрузке необходимо что-то сделать с getEmployeeDetail в рамках сессии,
            // чтобы получить эти данные позже
            session.getTransaction().commit();
            System.out.println(employee);
            System.out.println(employee.getEmployeeDetail());
        }

        return employee;
    }

    public List<Employee> getEmployees() {
        List<Employee> employees;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            employees = session.createQuery("from Employee").getResultList();
            session.getTransaction().commit();

            employees.forEach(System.out::println);
        }

        return employees;
    }

    public List<Employee> getEmployeesByCondition(String condition) {
        List<Employee> employees;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            employees = session.createQuery("from Employee where " + condition).getResultList();
            session.getTransaction().commit();

            employees.forEach(System.out::println);
        }

        return employees;
    }

    public Employee updateEmployeeSalaryById(int id, int salary) {
        Employee employee;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            employee = session.get(Employee.class, id);
            employee.setSalary(salary);
            session.getTransaction().commit();

            System.out.println(employee);
        }

        return employee;
    }

    public void updateEmployeesByCondition(String condition) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("update Employee " + condition).executeUpdate();
            session.getTransaction().commit();
        }
    }

    public Employee deleteEmployeeById(int id) {
        Employee employee;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            employee = session.get(Employee.class, id);
            session.remove(employee);
            session.getTransaction().commit();

            System.out.println(employee);
        }

        return employee;
    }

    public void deleteEmployeesByCondition(String condition) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete Employee where " + condition).executeUpdate();
            session.getTransaction().commit();
        }
    }
}
