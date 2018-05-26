package com.josesp.springbootdatajpa.dao;

import com.josesp.springbootdatajpa.model.Cliente;

import java.util.List;

public interface ClienteDao {

    List<Cliente> findAll();
    void save(Cliente cliente);
    Cliente findOne(Long id);

}
