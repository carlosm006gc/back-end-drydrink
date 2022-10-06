package com.dev.drydrink.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PrincipalController {

	@RequestMapping(value = "/administrativo", method = RequestMethod.GET)
	public String acessarPrincipal() {
		return "administrativo/index";		
	}
}
