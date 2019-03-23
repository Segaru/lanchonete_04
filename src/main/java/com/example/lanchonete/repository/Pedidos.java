package com.example.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.lanchonete.model.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Long> {
	
}