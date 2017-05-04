package br.com.fiap.amigoSecreto.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="usuario") 
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
	//private Blob fotoUsuario;
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="usuarios")
	private List<Grupo> grupos = new ArrayList<Grupo>();	
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY,
			mappedBy="usuario") 
	private List<SorteioAmigo> sorteioLista = new ArrayList<SorteioAmigo>();

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
	
	
	
}
