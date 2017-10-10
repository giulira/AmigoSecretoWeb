package br.com.fiap.amigoSecreto.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.amigoSecreto.dao.GrupoDAO;
import br.com.fiap.amigoSecreto.dao.UsuarioDAO;
import br.com.fiap.amigoSecreto.dao.util.RepositoryDao;
import br.com.fiap.amigoSecreto.entity.Grupo;
import br.com.fiap.amigoSecreto.entity.Usuario;

@ManagedBean(name="grupoMB")
@RequestScoped
public class GrupoMB {
	private String nomeGrupo;
	
	private GrupoDAO dao = new GrupoDAO();
	private UsuarioDAO userDao = new UsuarioDAO();
	private String idGrupoSelected;
	

	private List<Grupo> listaGrupos = new ArrayList<Grupo>();
	
	@ManagedProperty(value="#{beanGrupo}")
	private Grupo grupo;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public GrupoMB() {
		super();
	}
	
	public String incluirGrupo(Usuario usuario){

		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage();
		try {
			grupo.setStatus("Pendente");
			grupo.setIdAdministrador(usuario.getIdUsuario());
			GrupoDAO dao = RepositoryDao.getGruposDao();
			dao.adicionar(grupo);
			
			List<Usuario> listaUsuarios = new ArrayList<Usuario>();
			listaUsuarios.add(usuario);
			grupo.setUsuarios(listaUsuarios);
			dao.atualizar(grupo);			
			
			grupo.setEmpresa(usuario.getEmpresa());
			dao.atualizar(grupo);			
			
			msg.setDetail("Grupo " + grupo.getNome() + " incluido com sucesso!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			
		} catch (Exception e) {
			System.out.println("ERRO GRUPO: " + e.getMessage());
			msg.setSummary("ERRO:");
			msg.setDetail(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_INFO);			
		}
		
		context.addMessage(null, msg);		
		return "menu.xhtml";
	}

	public void pesquisarGrupo(Usuario usuario) {
	        FacesMessage message = null;
	        if(nomeGrupo == null || nomeGrupo.equals("") ) {
	            message = new FacesMessage("Digite o nome do grupo que voce deseja pesquisar.");
	        }
	       listaGrupos = dao.listarGrupo(nomeGrupo,usuario);
	       setListaGrupos(listaGrupos);
	}
	
	public void associarAoGrupo(Usuario usuario){

		FacesMessage msg = new FacesMessage();
		FacesContext context = FacesContext.getCurrentInstance();
		
		try{
			Map<String,String> params =	context.getExternalContext().getRequestParameterMap();
			String idGrupo = params.get("idgrupo");
			
			List<Usuario> listaUsuarios = new ArrayList<Usuario>();
			listaUsuarios.add(usuario);
			Grupo g1 = dao.buscarGrupoPorId(Integer.valueOf(idGrupo));
			g1.setUsuarios(listaUsuarios);
			dao.atualizar(g1);
			
			msg.setDetail("Grupo " + grupo.getNome() + " incluido com sucesso!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
		
		} catch (Exception e) {
			System.out.println("ERRO GRUPO: " + e.getMessage());
			msg.setSummary("ERRO:");
			msg.setDetail(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_INFO);		
		}
	}
	
	public List<Grupo> buscarGrupoPorUsuario(Usuario usuario){
		return dao.buscarGrupoPorUsuario(usuario);		
	}
	
	public Grupo buscarGrupoPorId(Integer id){
		return dao.buscarGrupoPorId(id);
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

	

	
}
