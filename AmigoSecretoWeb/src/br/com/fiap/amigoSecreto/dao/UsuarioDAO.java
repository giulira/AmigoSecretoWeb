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
			Usuario usuario = new Usuario();
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.email = :email and u.senha = :senha", Usuario.class);
			query.setParameter("email", email);
			query.setParameter("senha", senha);
			usuario = query.getSingleResult();
			return usuario;
		} catch (NoResultException e) {
			return null;
		} 
	}

	public Usuario buscaUsuario(String nome){
		try {
			Usuario usuario = new Usuario();
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.nome like :nome", Usuario.class);
			query.setParameter("nome","%"+nome+"%" );
			usuario = (Usuario) query.getSingleResult();
			return usuario;
		} catch (NoResultException e) {
			return null;
		} 
	}
	
	public Usuario buscaUsuarioPorId(Integer id){
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.id = :id", Usuario.class);
			
			query.setParameter("id", id);

			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} 
	}	

	
	public Usuario buscaUsuarioByUsername(String username){
		try {
			Usuario usuario = new Usuario();
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.username = :username", Usuario.class);
			query.setParameter("username", username);
			usuario = (Usuario) query.getSingleResult();
			
			return usuario;
		} catch (NoResultException e) {
			return null;
		} 
	}	
	
}
