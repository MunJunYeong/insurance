package User;

import java.sql.ResultSet;
import java.util.ArrayList;

import Dao.UserDao;
import global.Util;

public class UserListImpl implements UserList{

	 private UserDao userDao = new UserDao();
	 
     public UserListImpl() {
     }

	@Override
	public ResultSet findUser(Long userIdx) {
		ResultSet rs = userDao.getOneUser(userIdx);
		return rs;
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
	public ResultSet getUserList() {
		ResultSet rs = userDao.findUserList();
		return rs;
	}
     
    
    
}
