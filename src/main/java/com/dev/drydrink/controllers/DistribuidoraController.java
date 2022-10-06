package com.dev.drydrink.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DistribuidoraController {

	@RequestMapping("/cadastrarDistribuidora")
	public String form() {
		return "formDistribuidora";
	}
}
