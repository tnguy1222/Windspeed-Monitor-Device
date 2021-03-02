/*Adam Bender
Jim Nguyen
Milestone 4
February 21, 2021
User Business Service*/

package business;

import javax.ejb.Local;
import javax.ejb.Stateless;

import beans.Database;
import beans.User;
import data.UserDataService;

@Stateless
@Local
public class UserBusinessService implements UserBusinessServiceInterface{

	/**
	 * Check login form username and password in the userdataservice
	 * @param user
	 * @return boolean
	 */
	public boolean authenticate(User user) 
	{
		Database db = new Database();
		UserDataService uds = new UserDataService(db);
		
		if(uds.findUser(user))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Register user to the database
	 * @param user
	 * @return boolean
	 */
	public boolean register(User user) 
	{
		Database db = new Database();
		UserDataService uds = new UserDataService(db);
		
		if(uds.createUser(user))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
