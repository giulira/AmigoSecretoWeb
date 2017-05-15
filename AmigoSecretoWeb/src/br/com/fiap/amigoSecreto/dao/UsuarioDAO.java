package br.com.fiap.amigoSecreto.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.amigoSecreto.dao.util.GenericDao;
import br.com.fiap.amigoSecreto.dao.util.JpaUtil;
import br.com.fiap.amigoSecreto.entity.Usuario;

public class UsuarioDAO  extends GenericDao<Usuario> {

	public UsuarioDAO() {
		super(Usuario.class);
	}

	
	public Usuario buscaUsuarioLogin(String email, String senha){
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.email = :email and u.senha = :senha", Usuario.class);
			query.setParameter("email", email);
			query.setParameter("senha", senha);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} 
	}
	
	public Usuario buscaUsuario(String nome){
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.nome = :nome", Usuario.class);
			query.setParameter("nome", nome);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} 
	}
	
	public Usuario buscaUsuarioByUsername(String username){
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.username = :username", Usuario.class);
			query.setParameter("username", username);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} 
	}	
	
}
