package br.com.fiap.amigoSecreto.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.amigoSecreto.dao.UsuarioDAO;
import br.com.fiap.amigoSecreto.dao.util.RepositoryDao;
import br.com.fiap.amigoSecreto.entity.Usuario;

@ManagedBean
@RequestScoped
public class UserBean {

	@ManagedProperty(value="#{beanUsuario}")
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public UsuarioDAO dao = RepositoryDao.getUsuariosDao();
	
	public String incluirUsuario(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage();
		try {
			dao.adicionar(usuario);
			msg.setDetail("Usuário " + usuario.getNome() + " incluído com sucesso!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			
		} catch (Exception e) {
			
			msg.setSummary("ERRO:");
			msg.setDetail(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_INFO);			
		}
		context.addMessage(null, msg);	
		return "login.xhtml";

	}
	
	public Usuario getUsuarioById(Integer id){
		return dao.buscaUsuarioPorId(id);
	}
}
