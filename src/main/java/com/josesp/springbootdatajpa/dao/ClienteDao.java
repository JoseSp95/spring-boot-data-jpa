package com.josesp.springbootdatajpa.dao;

import com.josesp.springbootdatajpa.model.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteDao extends CrudRepository<Cliente, Long> {

    /*
    List<Cliente> findAll();
    void save(Cliente cliente);
    Cliente findOne(Long id);
    void delete(Long id);
    */
}
