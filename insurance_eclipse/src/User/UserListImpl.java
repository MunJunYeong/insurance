package User;

import java.util.List;
import Dao.UserDao;


public class UserListImpl implements UserList{
 
	private UserDao userDao = new UserDao();

    public UserListImpl() {
    }


    @Override
	public boolean SignUp(User user) {
		return userDao.addUser(user);

	}

	@Override
	public boolean deleteUser(Long userIdx) {
		return userDao.deleteUser(userIdx);

	}

	
	@Override
	public List<User> getUserList() {
		List<User> userList = userDao.getUserList();
		return userList;

	}
}