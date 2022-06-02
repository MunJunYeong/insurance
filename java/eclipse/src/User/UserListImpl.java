package User;

import java.util.ArrayList;

import global.Util;

public class UserListImpl implements UserList{

     private ArrayList<User> userList;
     
     public UserListImpl() {
    	 this.userList = new ArrayList<User>();
     }
     
     public ArrayList<User> getUserList() {
    	 
    	 return this.userList;
     }

	@Override
	public String getInfo(int idx) {
		// TODO Auto-generated method stub
		return null;
//		return this.userList.get(idx).getInfo();
	}

	@Override
	public User findUser(int idx) {
		// TODO Auto-generated method stub
		return this.userList.get(idx);
	}
	
     
	   public boolean SignUp(User user) {
		      this.userList.add(user);      
		      return true;
		   }
		   
    
}
