package br.com.fiap.amigoSecreto.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="empresa")
@ManagedBean(name="beanEmpresa")
@RequestScoped
public class Empresa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_EMPRESA", unique=true, nullable=false, length=10)
	private Integer idEmpresa;
	@Column(name="NOME", nullable=false, length=50)
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="empresa") 
	private List<Grupo> grupoLista = new ArrayList<Grupo>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="empresa") 
	private List<Usuario> usuarioLista = new ArrayList<Usuario>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="empresa") 
	private List<ListaDesejos> desejosLista = new ArrayList<ListaDesejos>();
	
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
