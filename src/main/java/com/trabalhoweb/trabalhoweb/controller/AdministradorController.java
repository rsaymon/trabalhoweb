package com.trabalhoweb.trabalhoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.trabalhoweb.trabalhoweb.models.Administrador;
import com.trabalhoweb.trabalhoweb.repository.AdministradorRepository;

@Controller
public class AdministradorController {

	@Autowired
	private AdministradorRepository ar;
	
	@RequestMapping(value="/cadastrarAdministrador", method=RequestMethod.GET) //GET para retornar formulário
	public String form() {
		return "Administrador/formAdministrador";
	}
	
	@RequestMapping(value="/cadastrarAdministrador", method=RequestMethod.POST) //quando salvar mandar para essa requisição
	public String form(Administrador administrador) {
		
		ar.save(administrador);
		
		return "redirect:/cadastrarAdministrador";
	}
	
	@RequestMapping(value="/administradores")
	public ModelAndView listaAdministradores() {
		ModelAndView mv = new ModelAndView("Administrador/listarAdministradores");
		
		Iterable <Administrador> administradores = ar.findAll();
		
		mv.addObject("administradores", administradores);
		return mv;
	}
	
}