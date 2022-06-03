package User;

 

import java.util.List;

public interface UserList {

	public boolean SignUp(User user);

	public boolean deleteUser(Long userIdx);

	public List<User> getUserList();

//	public boolean updateUser();
}