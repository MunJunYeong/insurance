package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import User.User;

public class UserDao extends Dao{
	
	public UserDao() {
		super.connect();
	}	
	
	public boolean addUser(User user) {
		//남자면 FALSE(0) 여자면 TURE(1)
		int userSex = 0;
		if(user.isSex()) userSex=1;
		String sql = "INSERT INTO insurance.user VALUES("+
				"'" + user.getUserIdx()+ "', "+
				"'" + user.getCity()+"', "+
				"'" + user.getState()+"', "+
				"'" + user.getEmail()+"', "+
				"'" + user.getId()+"', "+
				"'" + user.getPw()+"', "+
				"'" + user.getJob()+"', "+
				"'" + user.getName()+"', "+
				"'" + userSex+"', "+
				"'" + user.getSsn()+"', "+
				"'" + user.getTel()+"');";
		System.out.println(sql);		
		return super.create(sql);
	}
	
	public ResultSet findUserList() {
		String sql = "SELECT * FROM insurance.user";
		System.out.println(sql);		

		ResultSet rs = super.retrieve(sql);
		System.out.println("Success");		
		return rs;
		
    }

	 public ResultSet getOneUser(Long userId) {
			String sql = "SELECT * FROM insurance.user where userId=" +
					"'"+ userId +"'";
			System.out.println(sql);
			ResultSet rs = super.retrieve(sql);
			return rs;
			

    }
	 
	 public boolean deleteUser(Long userId ) {
			String sql = "delete from insurance.user where userId=" +
					"'"+ userId +"'";
			System.out.println(sql);		
			return super.delete(sql);
	}
}
