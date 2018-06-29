package com.trabalhoweb.trabalhoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.trabalhoweb.trabalhoweb.models.Produto;
import com.trabalhoweb.trabalhoweb.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository pr;
	
	@RequestMapping(value="/cadastrarProduto", method=RequestMethod.GET) //GET para retornar formulário
	public String form() {
		return "produto/formProduto";
	}
	
	@RequestMapping(value="/cadastrarProduto", method=RequestMethod.POST) //quando salvar mandar para essa requisição
	public String form(Produto produto) {
		
		pr.save(produto);
		
		return "redirect:/cadastrarProduto";
	}
	
	@RequestMapping(value="/produtos")
	public ModelAndView listaProdutos() {
		ModelAndView mv = new ModelAndView("produtoIndex");
		
		Iterable <Produto> produtos = pr.findAll();
		
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@RequestMapping(value="/produtosAdm")
	public ModelAndView listaProdutosAdm() {
		ModelAndView mv = new ModelAndView("produto/listarProdutos");
		
		Iterable <Produto> produtos = pr.findAll();
		
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@RequestMapping("/{id}")
	public ModelAndView detalhesProduto(@PathVariable("id") long id){
		Produto produto = pr.findById(id);
		ModelAndView mv = new ModelAndView("produtoIndex");
		mv.addObject("produtos",produto);
		return mv;
	}
	
	@RequestMapping("/deletar")
	public String deletarProduto(long id) {
		
		Produto produto = pr.findById(id);
		pr.delete(produto);
		
		return "redirect:/produtosAdm";
	}
}