package ru.spin.spring.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppService<T> {
    List<T> getAll();

    T getById(int id);

    void save(T t);

    void delete(int id);

    List<T> findDistinctBySurnameOrderById(String surname);
}
