package br.com.fiap.amigoSecreto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="listaDesejos")
public class ListaDesejos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_LISTA", nullable=false, length=10)
	private Integer idLista;
	@Column(name="NOME", nullable=false, length=100)
	private String nome;
	@Column(name="TAMANHO", nullable=false, length=30)
	private String tamanho;
	@Column(name="LOJA", nullable=false, length=100)
	private String loja;
	@Column(name="PRECO", nullable=false, length=10)
	private Double preco;
	@Column(name="ID_USUARIO", nullable=false, length=10)
	private Integer idUsuario;
	@Column(name="ID_GRUPO", nullable=false, length=10)
	private Integer idGrupo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_EMPRESA") 
	private Empresa empresa;
	
	public Integer getIdLista() {
		return idLista;
	}
	public void setIdLista(Integer idLista) {
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
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
