package edu.curso.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.curso.entity.User;

@ManagedBean
@SessionScoped
public class UserBean {
	private User currentUser = new User();
	private boolean logged;
	
	public String login() { 
		if ("admin".equals(currentUser.getUserid()) 
				&& "1234".equals(currentUser.getPassword())) {
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
	
	public boolean isLogged() {
		return logged;
	}
	public void setLogged(boolean logged) {
		this.logged = logged;
	}
}
