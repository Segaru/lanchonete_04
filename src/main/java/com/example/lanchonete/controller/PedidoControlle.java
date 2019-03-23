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

import com.example.lanchonete.model.Pedido;
import com.example.lanchonete.repository.Pedidos;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Controller
@RequestMapping("/pedidos")
public class PedidoControlle {
	
	
	@Autowired
	private Pedidos pedidos;


	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaPedidos");
		mv.addObject(new Pedido());
		mv.addObject("pedidos", pedidos.findAll());
		return (mv);
	}

	@PostMapping
	public String salvar(Pedido pedido) {
		this.pedidos.save(pedido);
		return "redirect:/pedidos";
	}

	@RequestMapping(value ="/excluir/{id}")
	public String excluirPedidoByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		this.pedidos.deleteById(id);
		return "redirect:/pedidos";
	}
	
	@RequestMapping(value ="/alterar/{id}")
	public ModelAndView alterarPedidoByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("ListaPedidos");
		Pedido pedido = pedidos.getOne(id);
		mv.addObject(pedido);
		mv.addObject("pedidos", pedidos.findAll());
		return (mv);
	}
	
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}

}