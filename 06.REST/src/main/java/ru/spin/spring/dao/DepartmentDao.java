package ru.spin.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.spin.spring.entity.Department;

import java.util.List;

@Repository
public class DepartmentDao implements Dao<Department> {
    private SessionFactory sessionFactory;

    @Autowired
    public DepartmentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Department> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Department> departments = session.createQuery("from Department order by id", Department.class).getResultList();
        return departments;
    }

    @Override
    public Department getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Department dep = session.get(Department.class, id);
        return dep;
    }

    @Override
    public void save(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(department);
    }

    @Override
    public void delete(int id) {
        Department department = sessionFactory.getCurrentSession().load(Department.class, id);
        sessionFactory.getCurrentSession().delete(department);
    }
}
