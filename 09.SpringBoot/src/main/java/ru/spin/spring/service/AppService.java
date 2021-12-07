package ru.spin.spring.service;

import org.springframework.transaction.annotation.Transactional;

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
