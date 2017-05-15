package br.com.fiap.amigoSecreto.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.amigoSecreto.dao.GrupoDAO;
import br.com.fiap.amigoSecreto.dao.SorteioAmigoDAO;
import br.com.fiap.amigoSecreto.entity.Grupo;
import br.com.fiap.amigoSecreto.entity.SorteioAmigo;
import br.com.fiap.amigoSecreto.entity.Usuario;

@ManagedBean
@RequestScoped
public class SorteioAmigoBean {
	
	@ManagedProperty(value="#{beanGrupo}")
	private Grupo grupo;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public void sorteio(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage();
		GrupoDAO grupoDAO = new GrupoDAO();
		SorteioAmigoDAO sorteioDAO = new SorteioAmigoDAO();
		Grupo grupoEntity = grupoDAO.buscarGrupoPorId(grupo.getIdGrupo());
		List<Usuario> todos = grupoEntity.getUsuarios();
		
		try {		
			if (todos.size() < 2) {
				msg.setSummary("ERRO:");
				msg.setDetail("� necess�rio ter mais de dois usu�rios para realizar o sorteio!");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
			} else {
				sortearAmigos(todos);
				
				for(Usuario u : todos){
					System.out.println("O usuario " + u.getNome() + " sorteou o amigo: " + u.getAmigoSecreto().getNome());
					SorteioAmigo sorteado = new SorteioAmigo();
					sorteado.setAmigo(u.getAmigoSecreto());
					sorteado.setGrupo(grupo);
					sorteado.setUsuario(u);
					sorteioDAO.adicionar(sorteado);
				}
				
				msg.setSummary("OK");
				msg.setDetail("Sorteio realizado com sucesso!");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
			}

		} catch (Exception e) {
			msg.setSummary("ERRO:");
			msg.setDetail(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_INFO);	
		}	finally {
			grupoEntity.setStatus("Realizado");
			grupoDAO.atualizar(grupoEntity);
		}
		//context.addMessage(null, msg);
		
	}
	
	protected void sortearAmigos(List<Usuario> todos) {
		
		int indice = 0;
		List<Integer> jaSorteados = new ArrayList<Integer>();
		List<Usuario> auxiliar = new ArrayList<Usuario>(todos);
		
		for (Usuario usuario : todos) {			
			if(jaSorteados.size() == todos.size() - 1) {
				
				Usuario usuarioAuxiliar = auxiliar.get(0);
				
				if(usuario.equals(usuarioAuxiliar)) {
					Random random = new Random();
					Usuario usuarioSorteado = todos.get(random.nextInt(todos.size() - 1));
					usuario.setAmigoSecreto(usuarioSorteado.getAmigoSecreto());
					usuarioSorteado.setAmigoSecreto(usuarioAuxiliar);
	
					continue;
				}
				
				usuario.setAmigoSecreto(usuarioAuxiliar);
				continue;
				
			}
			
			indice = retornaIndice(todos.indexOf(usuario), todos.size(), jaSorteados);
			jaSorteados.add(indice);
			auxiliar.remove(todos.get(indice));
			
			usuario.setAmigoSecreto(todos.get(indice));
		}
		
	}
	

	protected int retornaIndice( int indiceUsuarioNaLista, int maxParaSorteio, List<Integer> jaSorteados ) {
		
		Random random = new Random();
		int indice = random.nextInt(maxParaSorteio);
		
		if(indice == indiceUsuarioNaLista){
			return retornaIndice(indiceUsuarioNaLista, maxParaSorteio, jaSorteados);
		} else if (jaSorteados.contains(indice)) {
			return retornaIndice(indiceUsuarioNaLista, maxParaSorteio, jaSorteados);
		}
		
		return indice;
			
	}

}
