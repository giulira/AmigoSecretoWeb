package br.com.fiap.amigoSecreto.dao.util;

import java.util.List;

import javax.faces.event.ActionEvent;

public interface Dao<T> {
	void adicionar(T entidade);
	void atualizar(T entidade);
	 List<T> listar();
	 T buscar(int id); 
	 void remover(T entidade);
	 void login(ActionEvent event);
}
