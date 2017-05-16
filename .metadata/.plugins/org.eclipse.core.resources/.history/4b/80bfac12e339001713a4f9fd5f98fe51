package br.com.fiap.amigoSecreto.bean;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 
import org.primefaces.context.RequestContext;
 
@ManagedBean
public class UserLoginView {
     
    private String email;
     
    private String senha;
 
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
   
    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(email != null && email.equals("admin") && senha != null && senha.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", email);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }   
}