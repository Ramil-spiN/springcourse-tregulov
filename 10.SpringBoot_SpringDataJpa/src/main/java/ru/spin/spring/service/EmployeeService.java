package ru.spin.spring.service;

import com.sun.source.tree.LabeledStatementTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spin.spring.dao.EmployeeRepository;
import ru.spin.spring.entity.Employee;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements AppService<Employee> {
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
//    @Transactional //При использовании JPARepository прописывать не нужно
    public List<Employee> getAll() {
        return employeeRepository.findAll(Sort.by("id"));
    }

    @Override
    public Employee getById(int id) {
        Employee employee = null;
        Optional<Employee> optEmp = employeeRepository.findById(id);
        if (optEmp.isPresent()) {
            employee = optEmp.get();
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findDistinctBySurnameOrderById(String surname) {
        return employeeRepository.findDistinctBySurnameOrderById(surname);
    }
}
