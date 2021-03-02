/*Adam Bender
Jim Nguyen
Milestone 4
February 21, 2021
Facade Interface*/

package business;

import beans.User;

public interface UserBusinessServiceInterface {

	boolean authenticate(User user);
	boolean register(User user);
}
