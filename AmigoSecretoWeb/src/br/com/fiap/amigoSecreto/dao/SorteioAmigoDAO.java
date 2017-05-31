package br.com.fiap.amigoSecreto.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.amigoSecreto.dao.util.GenericDao;
import br.com.fiap.amigoSecreto.dao.util.JpaUtil;
import br.com.fiap.amigoSecreto.entity.SorteioAmigo;

public class SorteioAmigoDAO extends GenericDao<SorteioAmigo> {

	public SorteioAmigoDAO() {
		super(SorteioAmigo.class);
	}

	public SorteioAmigo buscarAmigoSecretoPorUsuario(Integer usuarioId){
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			TypedQuery<SorteioAmigo> query = em.createQuery("select s from SorteioAmigo s where s.usuario.id = :id ", SorteioAmigo.class);
			query.setParameter("id", usuarioId);

			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
}
