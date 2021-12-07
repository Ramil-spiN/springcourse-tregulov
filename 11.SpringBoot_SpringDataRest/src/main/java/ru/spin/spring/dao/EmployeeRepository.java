package ru.spin.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.spin.spring.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
