package br.com.fiap.amigoSecreto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.amigoSecreto.dao.util.GenericDao;
import br.com.fiap.amigoSecreto.dao.util.JpaUtil;
import br.com.fiap.amigoSecreto.entity.Grupo;
import br.com.fiap.amigoSecreto.entity.Usuario;

public class GrupoDAO  extends GenericDao<Grupo> {

	public GrupoDAO() {
		super(Grupo.class);
	}

	public Grupo buscarGrupo(String chave){
		try {

			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();

			TypedQuery<Grupo> query = em.createQuery("select g from Grupo g where g.nome = :nome ", Grupo.class);

			query.setParameter("nome", chave);
			
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
	
	public Grupo buscarGrupoPorId(Integer id){
		try {

			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();

			TypedQuery<Grupo> query = em.createQuery("select g from Grupo g where g.id = :id ", Grupo.class);

			query.setParameter("id", id);

			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}	
	
	public List<Grupo> buscarGrupoPorUsuario(Usuario usuario){
		try {

			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();

			TypedQuery<Grupo> query = em.createQuery("select g from Grupo g JOIN g.usuarios u where u.idUsuario = :id and g.empresa = :idEmpresa", Grupo.class);

			query.setParameter("id", usuario.getIdUsuario());
			query.setParameter("idEmpresa", usuario.getEmpresa());

			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
		
	}
	
	public List<Grupo> listarGrupo(String chave, Usuario usuario){
		List<Grupo> listaGrupos = new ArrayList<Grupo>();
		try {

			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();

			TypedQuery<Grupo> query = em.createQuery("select g from Grupo g where g.nome like :nome and g.empresa = :idEmpresa", Grupo.class);

			query.setParameter("nome", "%"+chave+ "%");
			query.setParameter("idEmpresa", usuario.getEmpresa());
			listaGrupos = query.getResultList();
			return listaGrupos;
			
		} catch (NoResultException e) {
			return null;
		}
		
	}
	
	public List<Usuario> listarUsuariosDoGrupo(Integer id){
		try {

			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();

			TypedQuery<Grupo> query = em.createQuery("select g from Grupo g JOIN g.usuarios u where idGrupo = :id ", Grupo.class);

			query.setParameter("id", id);

			return query.getSingleResult().getUsuarios();
		} catch (NoResultException e) {
			return null;
		}
		
	}
}
