package br.com.fiap.amigoSecreto.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.amigoSecreto.dao.GrupoDAO;
import br.com.fiap.amigoSecreto.dao.UsuarioDAO;
import br.com.fiap.amigoSecreto.entity.Grupo;
import br.com.fiap.amigoSecreto.entity.Usuario;

@ManagedBean(name="grupoMB")
public class GrupoMB {
	private String nomeGrupo;
	private List<Grupo> listaGrupos = new ArrayList<Grupo>();
	private GrupoDAO dao = new GrupoDAO();
	private UsuarioDAO userDao = new UsuarioDAO();
	private String idGrupoSelected;
	
	public GrupoMB() {
		super();
	}

	public void pesquisarGrupo() {
	        FacesMessage message = null;
	        if(nomeGrupo == null || nomeGrupo.equals("") ) {
	            message = new FacesMessage("Digite o nome do grupo que você deseja pesquisar.");
	        }
	       listaGrupos = dao.listarGrupo(nomeGrupo);
	       
	        setListaGrupos(listaGrupos);
	}
	
	public void associarAoGrupo(){
		//String idGrupo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idGrupo");
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		String id = params.get("id");
		Usuario usuario = new Usuario();
		usuario = userDao.buscar(1);
		Grupo grupoSelecionado = new Grupo();
		grupoSelecionado = dao.buscarGrupo(idGrupoSelected);
		List<Grupo> lista = new ArrayList<Grupo>();
		lista.add(grupoSelecionado);
		usuario.setGrupos(lista);
		userDao.atualizar(usuario);
	       
        setListaGrupos(dao.listar());
	}
	
	public String listarMeusGrupo(){
		List<Grupo> lista = new ArrayList<Grupo>();
		Usuario usuario = new Usuario();
		usuario = userDao.buscar(1);
		lista = usuario.getGrupos();
		setListaGrupos(lista);
		
		return "meusGrupos.xhtml";
	}

	public List<Grupo> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(List<Grupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public String getIdGrupoSelected() {
		return idGrupoSelected;
	}

	public void setIdGrupoSelected(String idGrupoSelected) {
		this.idGrupoSelected = idGrupoSelected;
	}

	

	/*public void onRowSelect(SelectEvent event) {
		Integer id =  ((Grupo)event.getObject()).getIdGrupo();
		setIdGrupoSelected(String.valueOf(id));
    }*/
	
}
