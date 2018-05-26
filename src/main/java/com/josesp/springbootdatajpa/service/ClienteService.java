package com.josesp.springbootdatajpa.service;

import com.josesp.springbootdatajpa.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();
    void save(Cliente cliente);
    Cliente findOne(Long id);
    void delete(Long id);

}
