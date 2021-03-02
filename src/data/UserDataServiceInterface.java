/*Adam Bender
Jim Nguyen
Milestone 4
February 21, 2021
User Data Service Interface*/

package data;

import beans.User;

public interface UserDataServiceInterface {

	boolean createUser(User user);
	boolean findUser(User user);
}
