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
@Table(name="sorteioAmigo")
public class SorteioAmigo implements Serializable{
		
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id; 

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_USUARIO") 
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_GRUPO") 
	private Grupo grupo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_AMIGO") 
	private Usuario amigo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Usuario getAmigo() {
		return amigo;
	}

	public void setAmigo(Usuario amigo) {
		this.amigo = amigo;
	}

}
