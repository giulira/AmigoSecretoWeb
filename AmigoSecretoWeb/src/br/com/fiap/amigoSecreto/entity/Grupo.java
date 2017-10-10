package br.com.fiap.amigoSecreto.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="grupo")
@ManagedBean(name="beanGrupo")
@RequestScoped
public class Grupo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_GRUPO", unique=true, nullable=false, length=10)
	private Integer idGrupo;
	@Column(name="NOME", nullable=false, length=150)
	private String nome;
	@Column(name="DESCRICAO", nullable=false, length=200)
	private String descricao;
	@Column(name="TIPO", nullable=false, length=200)
	private String tipo;
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_SORTEIO", nullable=false, length=10)
	private Date dataSorteio;
	@Column(name="VALOR_MINIMO", nullable=false, length=10)
	private Double valorMinimo;
	@Column(name="VALOR_MAXIMO", nullable=false, length=10)
	private Double valorMaximo;
	@Column(name="STATUS", nullable=false, length=100)
	private String status;
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ENTREGA", nullable=false)
	private Date dataEntrega;
	@Column(name="LOCAL", nullable=false, length=200)
	private String local;	
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="GRUPO_USUARIO", catalog="amigosecreto", joinColumns =
	{@JoinColumn(name="ID_GRUPO", nullable=true, updatable=false)},
	inverseJoinColumns = {@JoinColumn(name="ID_USUARIO", nullable=false,
	updatable=false)})
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	@Column(name="ID_ADMIN", nullable=false, length=10)
	private Integer idAdministrador;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_EMPRESA") 
	private Empresa empresa;

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
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

	public Double getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(Double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public Double getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(Double valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	public Integer getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Integer idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
