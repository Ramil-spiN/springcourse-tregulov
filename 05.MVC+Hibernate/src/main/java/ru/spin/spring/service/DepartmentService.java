package ru.spin.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spin.spring.dao.Dao;
import ru.spin.spring.entity.Department;

import java.util.List;

@Service
public class DepartmentService implements AppService<Department> {
    Dao<Department> dao;

    @Autowired
    public DepartmentService(Dao<Department> dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<Department> getAll() {
        return dao.getAll();
    }

    @Override
    public Department getById(int id) {
        return dao.getById(id);
    }

    @Override
    //@Transactional //Аннотировали в интерфейсе AppService
    public void save(Department department) {
        dao.save(department);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
