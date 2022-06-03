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
	private boolean duplicateId = false;
	public PLogin(Lists lists) {
		System.out.println("---------------Login---------------");
		id = Util.StringReader("ID : ");
		pw = Util.StringReader("PW : ");
		type = null;
		
		for(User user : lists.getUserList()) {
			if(user.getId().equals(id)) {
				if(user.getPw().equals(pw)) {
					this.type = "user";
					this.user = user;
					duplicateId = true;
				}
			}
		}
		if(!duplicateId) {
			for(Employee employee : lists.getEmployeeList()) {
				if(employee.getId().equals(id)) {
					if(employee.getPw().equals(pw)) {
						this.type = "employee";
						this.employee = employee;
						duplicateId = true;
					}
				}
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
