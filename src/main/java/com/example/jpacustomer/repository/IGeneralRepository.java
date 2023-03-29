package com.example.jpacustomer.repository;

import java.util.List;

public interface IGeneralRepository<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void delete(Long id);
}
