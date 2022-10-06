package com.dev.drydrink.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class indexController {

	@RequestMapping(method = RequestMethod.GET, value = "/home")
	public String index() {
		return "cliente/index";
	}
}
