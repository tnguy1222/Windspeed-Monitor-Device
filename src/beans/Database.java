/*Adam Bender
Jim Nguyen
Milestone 4
February 21, 2021
Database Model*/

package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Database 
{
	String url = "jdbc:mysql://localhost:3306/cst361-clcproject";
	String user = "root";
	String pass = "root";
	
	public Database() 
	{

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
