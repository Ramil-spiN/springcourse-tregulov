package ru.spin.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.spin.spring.entity.Department;
import ru.spin.spring.entity.Detail;
import ru.spin.spring.entity.Employee;
import ru.spin.spring.entity.Section;

@Component("sectionDAO")
public class SectionDAO {
    SessionFactory sessionFactory;

    public SectionDAO() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Section.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
    }

    public void addSectionWithEmployees(Section section) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(section);
            session.getTransaction().commit();
        }
    }
}
