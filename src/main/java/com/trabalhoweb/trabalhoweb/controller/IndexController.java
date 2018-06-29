package com.trabalhoweb.trabalhoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String Index() {
		return "index";
	}
	
	@RequestMapping("/pacotes")
	public String Pacotes() {
		return "pacotes";
	}
	
	@RequestMapping("/sobre")
	public String Sobre() {
		return "sobre";
	}
	
	@RequestMapping("/contato")
	public String Contato() {
		return "contato";
	}
}