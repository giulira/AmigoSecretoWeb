package br.com.fiap.amigoSecreto.bean;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.amigoSecreto.dao.UsuarioDAO;
import br.com.fiap.amigoSecreto.entity.Usuario;
 
@ManagedBean(name="loginUsuarios")
@SessionScoped
public class UserLoginView {

	private UsuarioDAO dao = new UsuarioDAO();
	
	public UserLoginView(){
		usuario = new Usuario();
	}
 
	private Usuario usuario;
    
    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
   
	public String validarUsuario() throws Exception{
   		
		if(dao.buscaUsuarioLogin(usuario.getEmail(), usuario.getSenha()) != null){
			return "menu.xhtml";
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage();
			msg.setSummary("Erro Login: ");
			msg.setDetail("Usuário ou senha inválidos");
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			
			context.addMessage(null, msg);
			return "login.xhtml";
		}    
        
    }
    
}