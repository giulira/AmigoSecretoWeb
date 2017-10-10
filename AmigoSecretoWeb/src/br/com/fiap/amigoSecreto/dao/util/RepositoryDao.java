package br.com.fiap.amigoSecreto.dao.util;

import br.com.fiap.amigoSecreto.dao.EmpresaDAO;
import br.com.fiap.amigoSecreto.dao.GrupoDAO;
import br.com.fiap.amigoSecreto.dao.UsuarioDAO;

public class RepositoryDao {
	static UsuarioDAO usuarioDao;
	static GrupoDAO grupoDao;
	static EmpresaDAO empresaDao;
	
	public static UsuarioDAO getUsuariosDao() {
		if (usuarioDao == null) {
			usuarioDao = new UsuarioDAO();
		}
		return usuarioDao;
	}
	
	public static GrupoDAO getGruposDao() {
		if (grupoDao == null) {
			grupoDao = new GrupoDAO();
		}
		return grupoDao;
	}
	
	public static EmpresaDAO getEmpresasDao() {
		if (empresaDao == null) {
			empresaDao = new EmpresaDAO();
		}
		return empresaDao;
	}
}