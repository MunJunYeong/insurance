package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Accident.Accident;
import Employee.Employee;

public class EmployeeDao extends Dao{
	
	public EmployeeDao() {
		super.connect();
	}

	//???????
	 public void setInsentive(int grade1, int grade2, int grade3, int grade4) {
	 }
	 
	 //???????? 제공 로직이 필요한가
	 public void offerInsentive(Long idx, int insentive) {
	 }
	 
	 public boolean addEmployee(Employee employee) {
			String sql = "INSERT INTO insurance.employee VALUES("+
							"'" + employee.getEmployeeIdx()+ "', "+
							"'" + employee.getId()+"', "+
							"'" + employee.getName()+"', "+
							"'" + employee.getPw()+"', "+
							"'" + employee.getRole()+"', "+
							"'" + employee.getTel()+"', "+
							"'" + employee.getGrade()+"', "+
							"'" + employee.getAccountNumber()+"');";
			System.out.println(sql);		
			return super.create(sql);
		}	

		public ResultSet findOneEmployee(Long employeeIdx) {
			String sql = "SELECT * FROM insurance.employee where employeeIdx=" +
						"'"+ employeeIdx +"'";
			System.out.println(sql);
			ResultSet rs = super.retrieve(sql);
			
			return rs;
	    }
		
	//역할에 따른 employee 리스트 출력
	 public ResultSet findRoleList(String role) {
		String sql = "SELECT * FROM insurance.employee where role=" +
				"'"+ role +"'";
		ResultSet rs = super.retrieve(sql);
		return rs;
//		String message = null;
//		List<String> roleList = new ArrayList<>();
//		try {			
//			while(rs.next()) {
//			    String employeeIdx = rs.getString(1);
//			    String id = rs.getString(2);
//			    String name = rs.getString(3);
//			    String pw = rs.getString(4);
//			    String role2 = rs.getString(5);
//			    String tel = rs.getString(6);
//			    String grade = rs.getString(7);
//			    String  accountNumber = rs.getString(8);
//			    
//				message = employeeIdx+ " " + id + " " + name +" " +pw + "" + role2 + " " + tel + " " + grade + " " + accountNumber + "\n" ;
//				roleList.add(message);
//			}
//		} 
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return roleList;
	 }
	 
	public ResultSet getEmployeeList() {
		String sql = "SELECT * FROM insurance.employee";
		System.out.println(sql);		
		
		ResultSet rs = super.retrieve(sql);
		System.out.println("Success");	
		return rs;

	}
	
	public boolean deleteEmployee(Long employeeIdx ) {
		String sql = "delete from insurance.employee where employeeIdx=" +
				"'"+ employeeIdx +"'";
		System.out.println(sql);		
		return super.delete(sql);

	}
}
