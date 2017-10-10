package br.com.fiap.amigoSecreto.dao;

import br.com.fiap.amigoSecreto.dao.util.GenericDao;
import br.com.fiap.amigoSecreto.entity.Empresa;

public class EmpresaDAO extends GenericDao<Empresa> {

	public EmpresaDAO() {
		super(Empresa.class);
	}
}
