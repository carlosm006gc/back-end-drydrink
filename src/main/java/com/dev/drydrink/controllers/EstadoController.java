package com.dev.drydrink.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.drydrink.domain.Estado;
import com.dev.drydrink.repository.EstadoRepository;

@Controller
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/cadastrarEstado")
	public ModelAndView cadastrar(Estado estado) {
		ModelAndView mv = new ModelAndView("administrativo/estado/cadastrarEstado");
		mv.addObject("estado", estado);
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listarEstados")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/estado/lista");
		mv.addObject("listaEstado", estadoRepository.findAll());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/salvarEstado")
	public ModelAndView salvar(@Valid Estado estado, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(estado);
		}
		estadoRepository.save(estado);
		return cadastrar(new Estado());

	}

	@RequestMapping(method = RequestMethod.GET, value = "/editarEstado/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		return cadastrar(estado.get());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/removerEstado/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		estadoRepository.delete(estado.get());
		return listar();
	}

}
