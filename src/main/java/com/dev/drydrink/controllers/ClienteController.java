package com.dev.drydrink.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.drydrink.domain.Cliente;
import com.dev.drydrink.repository.ClienteRepository;

@Controller

public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@RequestMapping(method = RequestMethod.GET, value = "/cadastrarClientes")
	public ModelAndView cadastro(Cliente cliente) {
		ModelAndView mv = new ModelAndView("cliente/cadastrar");
		mv.addObject("cliente",cliente);
		return mv;
	}
	@RequestMapping(method = RequestMethod.POST, value = "/salvar")
	public ModelAndView salvar(@Valid Cliente cliente, BindingResult result) {
		if(result.hasErrors()) {
			return cadastro(cliente);
		}
		cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
		repository.save(cliente);
		return login(new Cliente());
	}
	@RequestMapping(method = RequestMethod.GET, value = "/loginClientes")
	public ModelAndView login(Cliente cliente) {
		ModelAndView mv = new ModelAndView("cliente/login");
		mv.addObject("cliente",cliente);
		return mv;
	}
}