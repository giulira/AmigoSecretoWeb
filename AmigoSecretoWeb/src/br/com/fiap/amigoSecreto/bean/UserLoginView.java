package br.com.fiap.amigoSecreto.bean;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;


import br.com.fiap.amigoSecreto.dao.UsuarioDAO;
import br.com.fiap.amigoSecreto.entity.Usuario;
 
@ManagedBean
public class UserLoginView {
     
    private String email; 
    private String senha;
    private UsuarioDAO userDao = new UsuarioDAO();
   
    public String login( ) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        Usuario usuario = new Usuario(); 
        if(email != null && email.equals("userDao") && senha != null && senha.equals("userDao")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo", email);
            usuario=userDao.buscaUsuarioLogin(email, senha);   
            return "teste.xhtml";
           
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao Logar", "Usuario ou senha invalidos");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
		return "login.xhtml";
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UsuarioDAO userDao) {
		this.userDao = userDao;
	}
    
   
    
    
    
    
    
}