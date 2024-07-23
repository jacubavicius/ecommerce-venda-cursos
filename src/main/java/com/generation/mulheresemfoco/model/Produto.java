package com.generation.mulheresemfoco.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo 'nome' é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo 'título' deve conter no mínimo 05 caracteres")
	private String nome;
	
	@NotBlank(message = "O atributo 'descricao' é obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo 'texto' deve conter no mínimo 10 e no máximo 1000 caracteres")
	private String descricao;
	
	@NotNull(message = "O atributo 'preco' é obrigatório!")
	private double preco;
	
	@NotBlank(message = "O atributo 'instrutor' é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo 'instrutor' deve conter no mínimo 05 caracteres")
	private	String instrutor;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	@JsonIgnoreProperties("produto")
	private List<Usuario> usuario;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
}
