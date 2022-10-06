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

import com.dev.drydrink.domain.Cidade;
import com.dev.drydrink.repository.CidadeRepository;
import com.dev.drydrink.repository.EstadoRepository;

@Controller
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/cadastrarCidade")
	public ModelAndView cadastrar(Cidade cidade) {
		ModelAndView mv = new ModelAndView("administrativo/cidade/cadastrarCidade");
		mv.addObject("cidade", cidade);
		mv.addObject("listaEstados", estadoRepository.findAll());
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listarCidades")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/cidade/lista");
		mv.addObject("listaCidade", cidadeRepository.findAll());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/salvarCidade")
	public ModelAndView salvar(@Valid Cidade cidade, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(cidade);
		}
		cidadeRepository.save(cidade);
		return cadastrar(new Cidade());

	}

	@RequestMapping(method = RequestMethod.GET, value = "/editarCidade/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		return cadastrar(cidade.get());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/removerCidade/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		cidadeRepository.delete(cidade.get());
		return listar();
	}

}
