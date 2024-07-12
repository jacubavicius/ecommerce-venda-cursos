package com.generation.mulheresemfoco.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotBlank(message = "O atributo 'nome' é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo 'nome' deve conter no mínimo 5 caracteres")
	private String nome;
	
	@NotNull(message = "O atributo 'usuario' é obrigatório!")
	@Size(max = 100)
	private String usuario;
	
	@NotNull(message = "O atributo 'senha' é obrigatório!")
	@Size(min = 6, message = "O atributo 'senha' deve conter no mínimo 6 caracteres")
	private String senha;
	
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties("usuario")
	private Produto produto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}

