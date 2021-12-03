package ru.spin.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.spin.spring.entity.Department;
import ru.spin.spring.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDao implements Dao<Employee> {
    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> employees = session.createQuery("from Employee order by id", Employee.class).getResultList();
        return employees;
    }

    @Override
    public Employee getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public void delete(int id) {
        Employee employee = sessionFactory.getCurrentSession().load(Employee.class, id);
        sessionFactory.getCurrentSession().delete(employee);
//        Эффективно (данные не загружаются; вместо этого в кэш сеанса помещается прокси-сервер)
//        Может быть непосредственно представлен в качестве услуги
//        Синхронизируется с кэшем сеанса

//        Query<Employee> query = session.createQuery("delete from Employee where id=:id");
//        query.setParameter("id", id);
//        query.executeUpdate();
//        Эффективно (ни один экземпляр не загружается из базы данных и не помещается в кэш сеанса)
//        Может быть непосредственно представлен в качестве услуги
//        Не синхронизировано с кэшем сеанса
//        Ненужное использование HQL
    }
}
