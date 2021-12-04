package ru.spin.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spin.spring.dao.Dao;
import ru.spin.spring.entity.Employee;

import java.util.List;

@Service
public class EmployeeService implements AppService<Employee> {
    Dao<Employee> dao;

    @Autowired
    public EmployeeService(Dao<Employee> dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<Employee> getAll() {
        return dao.getAll();
    }

    @Override
    public Employee getById(int id) {
        return dao.getById(id);
    }

    @Override
    //@Transactional //Аннотировали в интерфейсе AppService
    public void save(Employee employee) {
        dao.save(employee);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
