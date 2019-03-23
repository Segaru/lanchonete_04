package com.example.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.lanchonete.model.Lanche;

public interface Lanches extends JpaRepository<Lanche, Long> {
	
}