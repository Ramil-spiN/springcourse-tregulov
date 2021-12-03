package ru.spin.spring.service;

import org.springframework.transaction.annotation.Transactional;
import ru.spin.spring.entity.Employee;

import java.util.List;

public interface AppService<T> {
    List<T> getAll();

    @Transactional
    T getById(int id);

    @Transactional
    void save(T t);

    @Transactional
    void delete(int id);
}
