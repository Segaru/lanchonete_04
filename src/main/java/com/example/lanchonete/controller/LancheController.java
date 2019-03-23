package com.example.lanchonete.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.lanchonete.model.Lanche;
import com.example.lanchonete.repository.Lanches;
import com.example.lanchonete.repository.Pedidos;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Controller
@RequestMapping("/lanches")
public class LancheController {
	
	@Autowired
	private Lanches lanches; 
	
	@Autowired
	private Pedidos pedidos;

	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaLanches");
		mv.addObject(new Lanche());
		mv.addObject("pedidos",pedidos.findAll());
		mv.addObject("lanches", lanches.findAll());
		return (mv);
	}

	@PostMapping
	public String salvar(Lanche lanche) {
		this.lanches.save(lanche);
		return "redirect:/lanches";
	}

	@RequestMapping(value ="/excluir/{id}")
	public String excluirLancheByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		this.lanches.deleteById(id);
		return "redirect:/lanches";
	}
	
	@RequestMapping(value ="/alterar/{id}")
	public ModelAndView alterarLancheByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("ListaLanche");
		Lanche lanche = lanches.getOne(id);
		mv.addObject(lanche);
		mv.addObject("lanches", lanches.findAll());
		return (mv);
	}
	
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}

}