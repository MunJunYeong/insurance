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
	
	public void addUser(User user) {
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
		super.create(sql);
	}
	
	public List<String> findUserList() {
		String sql = "SELECT * FROM insurance.user";
		System.out.println(sql);		

		ResultSet rs = super.retrieve(sql);
		System.out.println("Success");		
		List<String> messages = new ArrayList<>();
		
		try {			
			while(rs.next()) {
				String userIdx = rs.getString(1);
			    String city = rs.getString(2);
			    String state = rs.getString(3);
			    String email = rs.getString(4);
			    String id = rs.getString(5);
			    String pw = rs.getString(6);
			    String job = rs.getString(7);
			    String name = rs.getString(8);
			    String sex = rs.getString(9);
			    String ssn = rs.getString(10);
			    String tel = rs.getString(11);
				
			    String message = userIdx + " " + city +" " +state + "" + email + " " + id + " " + pw + " " + job + " " + name+" " + sex+" " + ssn+" " + tel+ "\n" ;
			    messages.add(message);
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;
    }

	 public String getOneUser(Long userId) {
			String sql = "SELECT * FROM insurance.user where userId=" +
					"'"+ userId +"'";
			System.out.println(sql);
			ResultSet rs = super.retrieve(sql);
			
			String message = null;
			try {
				while(rs.next()) {
					String userIdx = rs.getString(1);
				    String city = rs.getString(2);
				    String state = rs.getString(3);
				    String email = rs.getString(4);
				    String id = rs.getString(5);
				    String pw = rs.getString(6);
				    String job = rs.getString(7);
				    String name = rs.getString(8);
				    String sex = rs.getString(9);
				    String ssn = rs.getString(10);
				    String tel = rs.getString(11);
				    
					message = userIdx + " " + city +" " +state + "" + email + " " + id + " " + pw + " " + job + " " + name+" " + sex+" " + ssn+" " + tel+ "\n" ;
				}
			} 
			 catch (SQLException e) {
				e.printStackTrace();
			}
			
			return message;
    }
	 
	 public void deleteUser(Long userId ) {
			String sql = "delete from insurance.user where userId=" +
					"'"+ userId +"'";
			System.out.println(sql);		
			super.delete(sql);
	}
}
