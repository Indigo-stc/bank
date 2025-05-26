package com.skhola.bank_api.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BaseCtrl<T, ID extends Serializable> {

    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getOne(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody T entity);
    public ResponseEntity<?> update(@RequestBody T entity, @PathVariable ID id);

    public ResponseEntity<?> delete(@PathVariable ID id);
    public ResponseEntity<?> saveAll(@ RequestBody List<T> list);

}
