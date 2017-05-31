package br.com.fiap.amigoSecreto.bean;

import java.util.ArrayList;
import java.util.List;

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
	private List<Grupo> listaGrupos = new ArrayList<Grupo>();
	private GrupoDAO dao = new GrupoDAO();
	private UsuarioDAO userDao = new UsuarioDAO();
	private String idGrupoSelected;
	
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
			
			msg.setSummary("OK");
			msg.setDetail("Grupo " + grupo.getNome() + " incluído");
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

	public void pesquisarGrupo() {
	        FacesMessage message = null;
	        if(nomeGrupo == null || nomeGrupo.equals("") ) {
	            message = new FacesMessage("Digite o nome do grupo que você deseja pesquisar.");
	        }
	       listaGrupos = dao.listarGrupo(nomeGrupo);
	       
	        setListaGrupos(listaGrupos);
	}
	
	public void associarAoGrupo(){
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
	
	public String listarMeusGrupos(){
		List<Grupo> lista = new ArrayList<Grupo>();
		//lista = dao.listar();
		Usuario usuario = new Usuario();
		usuario = userDao.buscar(1);
		lista = usuario.getGrupos();
		setListaGrupos(lista);
		
		return "meusGrupos.xhtml";
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
