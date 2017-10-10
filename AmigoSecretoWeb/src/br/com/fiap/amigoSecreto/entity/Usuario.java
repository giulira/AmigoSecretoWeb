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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="usuario")
@ManagedBean(name="beanUsuario")
@RequestScoped
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_USUARIO", unique=true, nullable=false, length=10)
	private Integer idUsuario;
	@Column(name="USERNAME", nullable=false, length=50)
	private String username;
	@Column(name="SENHA", nullable=false, length=50)
	private String senha;
	@Column(name="NOME", nullable=false, length=50)
	private String nome;
	@Column(name="CPF", nullable=false, length=20)
	private String cpf;
	@Column(name="EMAIL", nullable=false, length=50)
	private String email;
	@Column(name="SEXO", nullable=false, length=50)
	private String sexo;
	@Column(name="ADMIN", nullable=false, length=50)
	private boolean isAdmin;	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_EMPRESA") 
	private Empresa empresa;
	
	//private Blob fotoUsuario;
	@ManyToMany(fetch=FetchType.EAGER, mappedBy="usuarios")
	private List<Grupo> grupos = new ArrayList<Grupo>();	
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER,
			mappedBy="usuario") 
	private List<SorteioAmigo> sorteioLista = new ArrayList<SorteioAmigo>();

	@Transient
	private Usuario amigoSecreto;	
	
	public Usuario getAmigoSecreto() {
		return amigoSecreto;
	}

	public void setAmigoSecreto(Usuario amigoSecreto) {
		this.amigoSecreto = amigoSecreto;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<SorteioAmigo> getSorteioLista() {
		return sorteioLista;
	}

	public void setSorteioLista(List<SorteioAmigo> sorteioLista) {
		this.sorteioLista = sorteioLista;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
