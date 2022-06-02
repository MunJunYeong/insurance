package User;

import java.sql.ResultSet;

public interface UserList {

	public ResultSet findUser(Long userIdx);
	public boolean SignUp(User user);
	public boolean deleteUser(Long userIdx);
	public ResultSet getUserList();
	
}
