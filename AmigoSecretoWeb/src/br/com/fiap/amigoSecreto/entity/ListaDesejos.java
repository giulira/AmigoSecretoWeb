package br.com.fiap.amigoSecreto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ListaDesejos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_LISTA", nullable=false, length=10)
	private int idLista;
	@Column(name="NOME", nullable=false, length=10)
	private String nome;
	@Column(name="TAMANHO", nullable=false, length=10)
	private String tamanho;
	@Column(name="LOJA", nullable=false, length=10)
	private String loja;
	@Column(name="PRECO", nullable=false, length=10)
	private double preco;
	@Column(name="ID_USUARIO", nullable=false, length=10)
	private int idUsuario;
	
	public int getIdLista() {
		return idLista;
	}
	public void setIdLista(int idLista) {
		this.idLista = idLista;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getLoja() {
		return loja;
	}
	public void setLoja(String loja) {
		this.loja = loja;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	

}
