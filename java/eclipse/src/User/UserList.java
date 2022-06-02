package User;

import java.util.ArrayList;

public interface UserList {

	public String getInfo(int idx);

	public User findUser(int idx);

	public boolean SignUp(User user);
	
	public ArrayList<User> getUserList();
	
}
