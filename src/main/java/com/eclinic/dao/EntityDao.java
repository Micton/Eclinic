package com.eclinic.dao;



import java.util.List;

public interface EntityDao<T> {

    void add(T t);
    void delete(int id);
    void update(T t);
    List<T> getAll();
    T getById(int id);
}
