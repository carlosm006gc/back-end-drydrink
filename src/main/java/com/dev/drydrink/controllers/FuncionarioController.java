package com.dev.drydrink.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.drydrink.domain.Funcionario;
import com.dev.drydrink.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping("/cadastrarFuncionario")
	public ModelAndView cadastrar(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("administrativo/funcionarios/cadastrarFuncionario");
		mv.addObject("funcionario", funcionario);
		return mv;
	}
	@GetMapping("/editar")
	public ModelAndView editarF(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("administrativo/funcionarios/editarFuncionario");
		mv.addObject("funcionario", funcionario);
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value = "/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return editarF(funcionario.get());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listar")
	public ModelAndView listar(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("administrativo/funcionarios/lista");
		mv.addObject("listaFuncionario", funcionarioRepository.findAll());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/salvarFuncionario")
	public ModelAndView salvar(@Valid Funcionario funcionario, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(funcionario);
		}
		
		funcionarioRepository.save(funcionario);
		return cadastrar(new Funcionario());

	}
	@RequestMapping(method = RequestMethod.POST, value = "/editarFuncionario")
	public ModelAndView editar(@Valid Funcionario funcionario, BindingResult result) {
		if (result.hasErrors()) {
			return editarF(funcionario);
		}
		
		funcionarioRepository.save(funcionario);
		return listar(new Funcionario());

	}
	

	@RequestMapping(method = RequestMethod.GET, value = "/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		funcionarioRepository.delete(funcionario.get());
		return new ModelAndView("redirect:/listar");
	}

}
