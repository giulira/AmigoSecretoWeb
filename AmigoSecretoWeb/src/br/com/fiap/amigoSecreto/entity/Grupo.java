package br.com.fiap.amigoSecreto.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Grupo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_GRUPO", unique=true, nullable=false, length=10)
	private int idGrupo;
	@Column(name="NOME", nullable=false, length=150)
	private String nome;
	@Column(name="DESCRICAO", nullable=false, length=200)
	private String descricao;
	@Column(name="TIPO", nullable=false, length=10)
	private String tipo;
	@Column(name="DATA_SORTEIO", nullable=false, length=10)
	private Date dataSorteio;
	@Column(name="VALOR_MINIMO", nullable=false, length=10)
	private double valorMinimo;
	@Column(name="VALOR_MAXIMO", nullable=false, length=10)
	private double valorMaximo;
	@Column(name="STATUS", nullable=false, length=10)
	private int status;
	@Column(name="DATA_ENTREGA", nullable=false)
	private Date dataEntrega;
	@Column(name="LOCAL", nullable=false, length=200)
	private String local;	
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="GRUPO_USUAIO", catalog="amigosecreto", joinColumns =
	{@JoinColumn(name="ID_GRUPO", nullable=false, updatable=false)},
	inverseJoinColumns = {@JoinColumn(name="ID_USUARIO", nullable=false,
	updatable=false)})
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="GRUPO_USUAIO", catalog="amigosecreto", joinColumns =
	{@JoinColumn(name="ID_GRUPO", nullable=false, updatable=false)},
	inverseJoinColumns = {@JoinColumn(name="ID_AMIGO", nullable=false,
	updatable=false)})
	private List<Usuario> amigos = new ArrayList<Usuario>();
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="GRUPO_USUAIO", catalog="amigosecreto", joinColumns =
	{@JoinColumn(name="ID_GRUPO", nullable=false, updatable=false)},
	inverseJoinColumns = {@JoinColumn(name="ID_ADMIN", nullable=false,
	updatable=false)})
	private List<Usuario> listaAdmin = new ArrayList<Usuario>();
	
	//private Blob foto;

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDataSorteio() {
		return dataSorteio;
	}

	public void setDataSorteio(Date dataSorteio) {
		this.dataSorteio = dataSorteio;
	}

	public double getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public double getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(double valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<Usuario> amigos) {
		this.amigos = amigos;
	}

	public List<Usuario> getListaAdmin() {
		return listaAdmin;
	}

	public void setListaAdmin(List<Usuario> listaAdmin) {
		this.listaAdmin = listaAdmin;
	}
	
	
	
	
	
	
}
