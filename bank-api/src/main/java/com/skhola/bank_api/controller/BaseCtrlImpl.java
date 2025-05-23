package com.skhola.bank_api.controller;

import com.skhola.bank_api.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@CrossOrigin(origins="*")
public abstract class BaseCtrlImpl<T, ID extends Serializable> implements BaseCtrl<T,ID> {

    private final BaseService<T, ID> baseService;

    protected BaseCtrlImpl(BaseService<T, ID> baseService) {
        this.baseService = baseService;
    }

    // To obtain all records of the table
    @Override
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(baseService.findAll());
    }

    // to obtain one record through its pk or id
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable ID id){
        return ResponseEntity.status(HttpStatus.OK).body(baseService.findById(id));
    }

    // to save a new record
    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody T entity){
        return ResponseEntity.status(HttpStatus.CREATED).body(baseService.save(entity));
    }

    // to update a new record through its ID and the new values of in the entity
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody T entity, @PathVariable ID id) {
        return ResponseEntity.status(HttpStatus.OK).body(baseService.update(entity, id));
    }

    // to delete a record through its id
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ID id) {
        baseService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El registro ha sido eliminado");
    }

}
