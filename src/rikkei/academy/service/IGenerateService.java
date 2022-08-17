package rikkei.academy.service;

import java.util.List;

public interface IGenerateService<T> {
    List<T> findAll();
    void save(T t);
    T findByID(int id);
    void deleteById(int id);
}
