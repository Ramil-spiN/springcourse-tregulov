package ru.spin.spring.dao;

//import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.spin.spring.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDao implements Dao<Employee> {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAll() {
//        Session session = sessionFactory.getCurrentSession();
//        entityManager - это обертка над Session, поэтому вызываем метод unwrap
//        Session session = entityManager.unwrap(Session.class);
//        List<Employee> employees = session.createQuery("from Employee order by id", Employee.class).getResultList();

        //Используем чистый JPA без привязки к Hibernate
        List<Employee> employees = entityManager.createQuery("from Employee order by id").getResultList();

        return employees;
    }

    @Override
    public Employee getById(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);

        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId()); //Чтобы в response возвращался новый id
    }

    @Override
    public void delete(int id) {
//        Employee employee = getById(id);
//        Session session = entityManager.unwrap(Session.class);
//        session.delete(employee);

        Employee employee = entityManager.getReference(Employee.class, id);
        entityManager.remove(employee);

        //entityManager.createQuery("delete from Employee where id=:id").setParameter("id", id).executeUpdate();
    }
}
