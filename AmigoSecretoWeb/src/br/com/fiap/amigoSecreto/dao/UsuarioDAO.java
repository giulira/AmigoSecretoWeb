package br.com.fiap.amigoSecreto.dao;

import br.com.fiap.amigoSecreto.dao.util.GenericDao;
import br.com.fiap.amigoSecreto.entity.Usuario;

public class UsuarioDAO  extends GenericDao<Usuario> {

	public UsuarioDAO() {
		super(Usuario.class);
	}

}
