package br.com.fiap.amigoSecreto.dao.util;

import br.com.fiap.amigoSecreto.dao.GrupoDAO;
import br.com.fiap.amigoSecreto.dao.ListaDesejoDAO;
import br.com.fiap.amigoSecreto.dao.SorteioAmigoDAO;
import br.com.fiap.amigoSecreto.dao.UsuarioDAO;
import br.com.fiap.amigoSecreto.entity.Grupo;
import br.com.fiap.amigoSecreto.entity.SorteioAmigo;
import br.com.fiap.amigoSecreto.entity.Usuario;

public class Teste {

	public static void main(String[] args) {
		UsuarioDAO userDao = new UsuarioDAO();
		GrupoDAO grupoDAO = new GrupoDAO();
		ListaDesejoDAO listaDesejoDAO = new ListaDesejoDAO();
		SorteioAmigoDAO sorteioAmigoDAO = new SorteioAmigoDAO(); 
				

		// TESTE ADICIONANDO USUARIO
		/*Usuario user = new Usuario();
		user.setCpf("25095426803");
		user.setEmail("teste@teste.com.br");
		user.setNome("Giuliane Lira");
		user.setSenha("123");
		user.setSexo("Feminino");
		user.setUsername("giulira");
		
		userDao.adicionar(user);
		
		Usuario user = new Usuario();
		user.setCpf("58525395382");
		user.setEmail("teste123@teste.com.br");
		user.setNome("João Mendes");
		user.setSenha("123");
		user.setSexo("Masculino");
		user.setUsername("joaozinho");
		
		
		userDao.adicionar(user);*/
		
		// TESTE ADICIONANDO GRUPO
		/*Grupo grupo = new Grupo();
		grupo.setIdAdministrador(1);
		grupo.setDataEntrega(new Date());
		grupo.setDataSorteio(new Date());
		grupo.setDescricao("Grupo 1");
		grupo.setLocal("Barzinho da FIAP");
		grupo.setNome("Grupo 1");
		grupo.setStatus(0);
		grupo.setTipo("FESTA A FANTASIA");
		grupo.setValorMaximo(50d);
		grupo.setValorMinimo(20d);
		GrupoDAO grupoDAO = new GrupoDAO();
		grupoDAO.adicionar(grupo);*/
		
		//ADICIONANDO USUARIO NO GRUPO
		/*List<Usuario> listaUsuario = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();
		usuario = userDao.buscar(1);
		listaUsuario.add(usuario);
		
		Grupo grupo = new Grupo();
		grupo = grupoDAO.buscar(1);
		grupo.setUsuarios(listaUsuario);
		grupoDAO.atualizar(grupo);*/
		
		//ADICIONANDO LISTADESEJOS
	/*	ListaDesejos desejo1 = new ListaDesejos();
		desejo1.setIdGrupo(1);
		desejo1.setIdUsuario(1);
		desejo1.setLoja("FastShop");
		desejo1.setNome("cafeteira nespresso");
		desejo1.setPreco(100d);
		desejo1.setTamanho("Não necessario");
		listaDesejoDAO.adicionar(desejo1);
	*/
		
		Grupo grupo = new Grupo();
		grupo = grupoDAO.buscar(1);
		
		Usuario usuario1 = new Usuario();
		usuario1 = userDao.buscar(1);
		Usuario amigo1 = new Usuario();
		amigo1 = userDao.buscar(2);
		SorteioAmigo sorteioAmigo1 = new SorteioAmigo();
		sorteioAmigo1.setAmigo(amigo1);
		sorteioAmigo1.setGrupo(grupo);
		sorteioAmigo1.setUsuario(usuario1);
		
		Usuario usuario2 = new Usuario();
		usuario2 = userDao.buscar(2);
		Usuario amigo2 = new Usuario();
		amigo2 = userDao.buscar(1);
		SorteioAmigo sorteioAmigo2 = new SorteioAmigo();
		sorteioAmigo1.setAmigo(amigo2);
		sorteioAmigo1.setGrupo(grupo);
		sorteioAmigo1.setUsuario(usuario2);
		
		sorteioAmigoDAO.adicionar(sorteioAmigo1);
		sorteioAmigoDAO.adicionar(sorteioAmigo2);
		
	}

}
