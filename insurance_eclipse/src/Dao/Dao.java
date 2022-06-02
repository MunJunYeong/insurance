package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	private Connection con = null;
	private PreparedStatement prestmt= null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public void connect() {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dev?serverTimezone=UTC", "root", "lch6683!");
		 }catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean create(String query) {
		int count = 0;
		try {
			stmt = con.createStatement();
			count = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(count == 0) {
			System.out.println("Fail:INSERT DATA");
			return false;
		}
		else {
			System.out.println("SUCCESS:INSERT DATA");
			return true;
		}

	}
	
	public boolean update(String query) {
		int count = 0;
		try {
			prestmt = con.prepareStatement(query);
			count = prestmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}if(count == 0) {
			System.out.println("Fail:INSERT DATA");
			return false;
		}
		else {
			System.out.println("SUCCESS:INSERT DATA");
			return true;
		}
	}
	
	public boolean delete(String query) {
		int count = 0;
		try {
			prestmt = con.prepareStatement(query);
			count = prestmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}if(count == 0) {
			System.out.println("Fail:INSERT DATA");
			return false;
		}
		else {
			System.out.println("SUCCESS:INSERT DATA");
			return true;
		}

	}
	
	//검색
	public ResultSet retrieve(String query) {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
//			stmt = con.prepareStatement(query);
//			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
}
