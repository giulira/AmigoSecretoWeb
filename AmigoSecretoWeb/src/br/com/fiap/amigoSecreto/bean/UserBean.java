package br.com.fiap.amigoSecreto.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.amigoSecreto.dao.RepositoryDao;
import br.com.fiap.amigoSecreto.dao.UsuarioDAO;
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
	
	public void incluirUsuario(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage();
		try {
			UsuarioDAO dao = RepositoryDao.getUsuariosDao();
			dao.adicionar(usuario);
			msg.setSummary("OK");
			msg.setDetail("Usuário " + usuario.getNome() + " incluído");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			
		} catch (Exception e) {
			
			msg.setSummary("ERRO:");
			msg.setDetail(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_INFO);			
		}
		context.addMessage(null, msg);		
	}
}
