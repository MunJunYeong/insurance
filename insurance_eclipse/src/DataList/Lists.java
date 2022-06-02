package DataList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Accident.Accident;
import Accident.AccidentList;
import Accident.AccidentListImpl;
import Contract.Contract;
import Contract.ContractList;
import Contract.ContractListImpl;
import Employee.Employee;
import Employee.EmployeeList;
import Employee.EmployeeListImpl;
import Insurance.Insurance;
import Insurance.InsuranceList;
import Insurance.InsuranceListImpl;
import User.User;
import User.UserList;
import User.UserListImpl;

public class Lists {

	private UserList userList;
	private EmployeeList employeeList;
	private AccidentList accidentList;
	private ContractList contractList;
	private InsuranceList insuranceList;

	public Lists() {
		this.userList = new UserListImpl();
		this.employeeList = new EmployeeListImpl();
		this.accidentList = new AccidentListImpl();
		this.contractList = new ContractListImpl();
		this.insuranceList = new InsuranceListImpl();
	}
	
	public List<String> getUserList() {
		ResultSet rs = this.userList.getUserList();
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
	
	public List<String> getEmployeeList() {
		ResultSet rs = this.employeeList.getEmployeeList();
		List<String> messages = new ArrayList<>();
		
		try {
			while(rs.next()) {
			    String idx = rs.getString(1);
			    String id = rs.getString(2);
			    String name = rs.getString(3);
			    String pw = rs.getString(4);
			    String role = rs.getString(5);
			    String tel = rs.getString(6);
			    String grade = rs.getString(7);
			    String accountNumber = rs.getString(8);

			    String message = idx + " " + id + " " + name +" " +pw + "" + role + " " + tel + " " + grade + " " + accountNumber + "\n" ;
			    messages.add(message);
			}
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;	
	}
	
	public List<String> getAccidentList() {
		ResultSet rs = this.accidentList.getAccidentList();
		List<String> messages = new ArrayList<>();
		try {
			while(rs.next()) {
			    String idx = rs.getString(1);
			    String type = rs.getString(2);
			    String content = rs.getString(3);
			    String accidentDate = rs.getString(4);
			    String damagePrice = rs.getString(5);
			    String compensationPrice = rs.getString(6);
			    String userIdx = rs.getString(7);
			    String insuranceIdx = rs.getString(8);
			    String employeeIdx = rs.getString(9);
			    String checkAccident = rs.getString(10);
			    String  lawsuitStaus = rs.getString(11);

			    String message = idx+ " " + type + " " + content +" " +accidentDate + "" + damagePrice + " " + compensationPrice + " " + checkAccident + " " + lawsuitStaus + "\n" ;
			    messages.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;
	}
	
	public List<String> getContractList() {
		ResultSet rs = this.contractList.getContractList();
		List<String> messages = new ArrayList<>();
		
		try {
			while(rs.next()) {
				String contractIdx = rs.getString(1);
				String created = rs.getString(2);
				String subscription = rs.getString(3);
				String suggestion = rs.getString(4);
				String checkSub = rs.getString(5);
				String checkSug = rs.getString(6);
				String checkUw = rs.getString(7);
				String checkpay = rs.getString(8);
				String userIdx = rs.getString(9);
				String employeeIdx = rs.getString(10);
				String insuranceIdx = rs.getString(11);

			    String message = contractIdx + " " + created +" " +subscription + "" + suggestion + " " + 
					    checkSub + " " + checkSug+ " " + checkUw + " " + checkpay + " " +
					    userIdx + " " + employeeIdx+" " + insuranceIdx+"\n" ;
			    messages.add(message);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return messages;
		
	}
//	public List<String> getInsuranceList() {
//		ResultSet rs = this.employeeList.getEmployeeList();
//		return this.insuranceList;
//	}
//	
	public boolean addEmployee(Employee employee) {
		return this.employeeList.SignUp(employee);
	}
	
	public boolean addAccident(Accident accident) {
		return this.accidentList.createAccident(accident);
	}
	public boolean addContract(Contract contract) {
		return this.contractList.createContract(contract);
	}
	public boolean addUser(User user) {
		return this.userList.SignUp(user);
	}
//	public boolean addInsurance(Insurance insurance) {
//		
//	}
	
	public String findOneEmployee(Long employeeIdx) {
		ResultSet rs = this.employeeList.findEmployee(employeeIdx);
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
	public String findOneAccident(Long accidentIdx) {
		ResultSet rs = this.accidentList.findAccident(accidentIdx);
		String message = null;
		try {
			while(rs.next()) {
			    String idx = rs.getString(1);
			    String type = rs.getString(2);
			    String content = rs.getString(3);
			    String accidentDate = rs.getString(4);
			    String damagePrice = rs.getString(5);
			    String compensationPrice = rs.getString(6);
//			    String userIdx = rs.getString(7);
//			    String insuranceIdx = rs.getString(8);
//			    String employeeIdx = rs.getString(9);
			    String checkAccident = rs.getString(10);
			    String  lawsuitStaus = rs.getString(11);
			    
			    message = idx+" " + type + " " + content +" " +accidentDate + "" + damagePrice + " " + compensationPrice + " " + checkAccident + " " + lawsuitStaus + "\n" ;
			    
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;	
	}
	
	public String findOneContract(Long contractIdx) {
		ResultSet rs = this.contractList.findContract(contractIdx);
		String message = null;
		try {
			while(rs.next()) {
				String contractIdx2 = rs.getString(1);
				String created = rs.getString(2);
				String subscription = rs.getString(3);
				String suggestion = rs.getString(4);
				String checkSub = rs.getString(5);
				String checkSug = rs.getString(6);
				String checkUw = rs.getString(7);
				String checkpay = rs.getString(8);
				String userIdx = rs.getString(9);
				String employeeIdx = rs.getString(10);
				String insuranceIdx = rs.getString(11);
			    
			    message = contractIdx + " " + created +" " +subscription + "" + suggestion + " " + 
				    checkSub + " " + checkSug+ " " + checkUw + " " + checkpay + " " +
				    userIdx + " " + employeeIdx+" " + insuranceIdx+"\n" ;
			}
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return message;	
	}
	
	public String findOneUser(Long userIdx) {
		ResultSet rs = this.userList.findUser(userIdx);
		String message = null;
		try {
			while(rs.next()) {
				String userIdx2 = rs.getString(1);
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
			    
				message = userIdx2 + " " + city +" " +state + "" + email + " " + id + " " + pw + " " + job + " " + name+" " + sex+" " + ssn+" " + tel+ "\n" ;
			}
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	
//	public String findoneInsurance(Long insuranceIdx) {
//	}
	
	public boolean deleteEmployee(Long employeeIdx) {
		return this.employeeList.deleteEmployee(employeeIdx);
	}

	public boolean deleteAccident(Long accidentIdx) {
		return this.accidentList.deleteAccident(accidentIdx);
	}

	public boolean deleteContract(Long contractIdx) {
		return this.contractList.deleteContract(contractIdx);
	}

	public boolean deleteUser(Long userIdx) {
		return this.userList.deleteUser(userIdx);
	}

//	public boolean deleteInsurance(Long userIdx) {
//	}

}
