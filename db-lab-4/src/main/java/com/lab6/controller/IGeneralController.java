package com.lab6.controller;


import com.lab6.service.IGeneralService;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;


public interface IGeneralController<T> {

    IGeneralService<T> getService();
    List<T> findAll();
    T findById(Integer id);
    void create(T t);
    void update(Integer id, T t);
    void delete(Integer id);
}