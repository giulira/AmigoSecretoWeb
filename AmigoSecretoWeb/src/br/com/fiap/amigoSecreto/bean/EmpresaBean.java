package br.com.fiap.amigoSecreto.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.amigoSecreto.dao.EmpresaDAO;
import br.com.fiap.amigoSecreto.dao.UsuarioDAO;
import br.com.fiap.amigoSecreto.dao.util.RepositoryDao;
import br.com.fiap.amigoSecreto.entity.Empresa;
import br.com.fiap.amigoSecreto.entity.Usuario;

@ManagedBean
@RequestScoped
public class EmpresaBean {

	@ManagedProperty(value="#{beanEmpresa}")
	private Empresa empresa;

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@ManagedProperty(value="#{beanUsuario}")
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public EmpresaDAO dao = RepositoryDao.getEmpresasDao();
	public UsuarioDAO daoUser = RepositoryDao.getUsuariosDao();
	
	public String incluirEmpresa(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage();
		try {
			dao.adicionar(empresa);
			
			usuario.setEmpresa(empresa);
			usuario.setAdmin(true);
			daoUser.adicionar(usuario);
			
			msg.setDetail("Empresa " + empresa.getNome() + " criada com sucesso!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			
			msg.setSummary("ERRO:");
			msg.setDetail(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_INFO);			
		}
		context.addMessage(null, msg);	
		return "login.xhtml";
	}
}
