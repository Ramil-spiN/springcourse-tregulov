package ru.spin.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.spin.spring.entity.Department;
import ru.spin.spring.entity.Detail;
import ru.spin.spring.entity.Employee;
import ru.spin.spring.entity.Section;

@Component("departmentDAO")
public class DepartmentDAO {
    SessionFactory sessionFactory;

    public DepartmentDAO() {
        this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
    }

    public Department addDepartmentWithEmployees(Department department) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();

            System.out.println(department);
        }

        return department;
    }

    public Department getDepartmentById(int id) {
        Department department = null;

        try (Session session = sessionFactory.getCurrentSession()) {
        session.beginTransaction();
            department = session.get(Department.class, id);
            session.getTransaction().commit();

            System.out.println(department);
        }

        return department;
    }
}
