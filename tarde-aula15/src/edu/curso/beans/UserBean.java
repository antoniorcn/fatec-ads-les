package edu.curso.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.curso.entity.User;
@ManagedBean
@SessionScoped
public class UserBean {
	
	private User currentUser = new User();
	private Boolean logged = false;
	
	public UserBean() { 
		
	}
	
	public String login() { 
		if ("admin".equals(currentUser.getUserid())
				&& "123456".equals(currentUser.getPassword())) { 
			logged = true;
			return "pets?faces-redirect=true";
		} else { 
			logged = false;
			return "login?faces-redirect=true";
		}
	}
	
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public Boolean getLogged() {
		return logged;
	}
	public void setLogged(Boolean logged) {
		this.logged = logged;
	}
}
