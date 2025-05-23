package com.skhola.bank_api.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {

    List<T> findAll();
    T findById(ID id);
    T save(T entity);
    void deleteById(ID id);
    T update(T t, ID id);
    List<T> saveAll(List<T> list);

}
