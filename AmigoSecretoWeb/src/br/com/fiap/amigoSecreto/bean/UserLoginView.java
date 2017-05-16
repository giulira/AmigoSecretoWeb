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
    
    private UsuarioDAO dao = new UsuarioDAO();
 
    public String getUsername() {
        return email;
    }
 
    public void setUsername(String username) {
        this.email = username;
    }
 
    public String getPassword() {
        return senha;
    }
 
    public void setPassword(String password) {
        this.senha = password;
    }
   
    public String login() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        Usuario usuario = new Usuario();
        String retorno = ""; 
         
        if((email != null && !email.equals("")) && (senha != null && !senha.equals(""))) {
            loggedIn = true;
            
           usuario = dao.buscaUsuarioLogin(email, senha);
           
           if(usuario != null){
        	   retorno = "perfil.xhtml";
           }
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            retorno = "";
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", loggedIn);
            
        }
         
       
       
        
        return retorno;
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
    
    
}