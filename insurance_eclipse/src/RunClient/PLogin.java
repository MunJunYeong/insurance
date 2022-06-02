package RunClient;

import DataList.Lists;
import Employee.Employee;
import User.User;
import global.Util;

public class PLogin {

	private String id = "";
	private String pw = "";
	private User user;
	private Employee employee;
	private String type;

	
	
	public PLogin(Lists lists) {
		System.out.println("---------------Login---------------");
		id = Util.StringReader("ID : ");
		pw = Util.StringReader("PW : ");
	
		
		//employee login
		for (int i = 0; i < lists.getEmployeeList().getEmployeeList().size(); i++) {
			if (lists.getEmployeeList().getEmployeeList().get(i).getId().equals(this.id)
					&& lists.getEmployeeList().getEmployeeList().get(i).getPw().equals(this.pw)) {			
				this.type = "employee";
				this.employee = lists.getEmployeeList().getEmployeeList().get(i);
			}
		}
		
		for (int i = 0; i < lists.getUserList().getUserList().size(); i++) {
			if (lists.getUserList().getUserList().get(i).getId().equals(this.id)
					&& lists.getUserList().getUserList().get(i).getPw().equals(this.pw)) {
				this.type = "user";
				this.user = lists.getUserList().getUserList().get(i);
			}
		}
		
	}
	
	public String getType() {
		return this.type;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public Employee getEmployee() {
		return this.employee;
	}

}
