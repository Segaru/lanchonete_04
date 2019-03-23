package com.example.lanchonete.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.example.lanchonete.model.Lanche;
import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("deprecation")
@Entity
public class Pedido  {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nome é obrigatória")
	@Size(max = 30, message = "O Nome não pode conter mais de 30 caracteres")
	private String mesa;
	private String tempoEspera;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Set<Lanche> lanches;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMesa() {
		return mesa;
	}
	public void setMesa(String mesa) {
		this.mesa = mesa;
	}
	public String getTempoEspera() {
		return tempoEspera;
	}
	public void setTempoEspera(String tempoEspera) {
		this.tempoEspera = tempoEspera;
	}
	public Set<Lanche> getLanches() {
		return lanches;
	}
	public void setLanches(Set<Lanche> lanches) {
		this.lanches = lanches;
	}
	
	
	
	
}
