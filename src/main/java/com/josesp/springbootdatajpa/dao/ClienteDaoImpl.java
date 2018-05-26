package com.josesp.springbootdatajpa.dao;

import com.josesp.springbootdatajpa.model.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// @Repository
public class ClienteDaoImpl {

    // public class ClienteDaoImpl implements ClienteDao , borramos esto para usar el CRUDRepository

    /*
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cliente> findAll() {
        return entityManager.createQuery("from Cliente").getResultList();
    }

    @Override
    public void save(Cliente cliente){
        System.out.println(cliente.toString());
        if (cliente.getId() == null){
             entityManager.persist(cliente);
        } else{
            if (cliente.getId() >= 0){
                entityManager.merge(cliente);
            }
        }

    }

    @Override
    public Cliente findOne(Long id) {
        if (id != null){
            if (id >= 0){
                return entityManager.find(Cliente.class, id);
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (id != null && id >= 0){
            Cliente cliente = this.findOne(id);
            if (cliente != null){
                entityManager.remove(cliente);
            }
        }
    }
*/

}
