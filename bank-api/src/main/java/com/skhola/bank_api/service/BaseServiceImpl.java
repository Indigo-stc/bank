package com.skhola.bank_api.service;

import com.skhola.bank_api.exception.ResourceNotFoundException;
import com.skhola.bank_api.repository.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    private final BaseRepository<T, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<T, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public List<T> findAll() {
        List<T> entities = baseRepository.findAll();
        if (entities.isEmpty()) {
            throw new ResourceNotFoundException("There aren't records");
        }
        return entities;
    }

    @Override
    public T findById(ID id) {
        Optional<T> entity = baseRepository.findById(id);
        if (entity.isEmpty()) {
            throw new ResourceNotFoundException("Record not found with ID: " + id);
        }
        return entity.get();
    }

    @Override
    @Transactional
    public T save(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public T update(T t, ID id) {
        Optional<T> current = baseRepository.findById(id);
        if (current.isPresent()) {
            T entity = current.get();
            BeanUtils.copyProperties(t, entity);
            return baseRepository.save(entity);
        }
        throw new ResourceNotFoundException("Recurso no encontrado para el ID: " + id + " por lo que no se puede actualizar.");
    }

    @Override
    public List<T> saveAll(List<T> list) {
        return baseRepository.saveAll(list);
    }

}
