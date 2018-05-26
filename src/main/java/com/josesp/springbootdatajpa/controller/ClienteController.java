package com.josesp.springbootdatajpa.controller;

import com.josesp.springbootdatajpa.dao.ClienteDao;
import com.josesp.springbootdatajpa.model.Cliente;
import com.josesp.springbootdatajpa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;


@Controller
@SessionAttributes(value = "cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Clientes");
        model.addAttribute("clientes", clienteService.findAll());
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
    public String crear(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status){
        model.addAttribute("titulo", "Formulario de Clientes");
        if (result.hasErrors()){
            return "form";
        }
        clienteService.save(cliente);
        status.setComplete();
        return "redirect:listar";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Map<String, Object> model){
        Cliente cliente;
        if (id != null && id >= 0){
            cliente = clienteService.findOne(id);
            System.out.println(cliente.toString());
            model.put("cliente", cliente);
            return "form";
        } else {
          return "redirect:/listar";
        }
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        if (id != null && id >= 0){
            clienteService.delete(id);
        }
        return "redirect:/listar";
    }
}
