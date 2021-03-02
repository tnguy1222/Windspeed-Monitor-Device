/*Adam Bender
Jim Nguyen
Milestone 4
February 21, 2021
Account Controller*/

package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;
import business.UserBusinessService;

@ManagedBean
@ViewScoped
public class AccountController {
	
	UserBusinessService ubs = new UserBusinessService();

	/**
	 * Call authenticate in the UserBusinessService
	 * 
	 * @param user
	 * @return
	 */
	public String authenticate(User user) {
		// if user is authenticated go home else display error
		if (ubs.authenticate(user)) {
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
			return "LoginSuccessPage.xhtml";
		
		} else {
			return "FailPage.xhtml";
		}
	}

	/**
	 * Calls register in the UserBusinessService
	 * 
	 * @param user
	 * @return
	 */
	public String register(User user) {
		// if user is found go home else display error
		if (ubs.register(user)) {
			return "RegisterSuccessPage.xhtml";
		} else {
			return "FailPage.xhtml";
		}
	}
}
