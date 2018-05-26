package com.josesp.springbootdatajpa.controller;

import com.josesp.springbootdatajpa.dao.ClienteDao;
import com.josesp.springbootdatajpa.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class ClienteController {

    @Autowired
    private ClienteDao clienteDao;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Clientes");
        model.addAttribute("clientes", clienteDao.findAll());
        return "listar";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Map<String, Object> model){
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario de clientes");
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String crear(@Valid Cliente cliente, BindingResult result, Model model){
        model.addAttribute("titulo", "Formulario de Clientes");
        if (result.hasErrors()){
            return "form";
        }
        clienteDao.save(cliente);
        return "redirect:listar";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Map<String, Object> model){
        Cliente cliente;
        if (id != null && id >= 0){
            cliente = clienteDao.findOne(id);
            System.out.println("---->" + cliente.getId() + "-- " + cliente.getNombre());
            model.put("cliente", cliente);
            return "form";
        } else {
          return "redirect:/listar";
        }
    }


}
