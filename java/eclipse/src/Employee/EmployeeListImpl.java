package Employee;

import java.util.ArrayList;

import User.UserListImpl;
import global.Util;

public class EmployeeListImpl implements EmployeeList {

	private ArrayList<Employee> employeeList;

	public EmployeeListImpl() {

		this.employeeList = new ArrayList<Employee>();
		  Employee employee = new Employee();
	      employee.setEmployeeIdx((long)0);   
	      employee.setId("b");
	      employee.setName("b");
	      employee.setPw("b");
	      employee.setRole("Salesman");
	      employee.setTel("b");
	      employee.setAccountNumber("b");
	      this.employeeList.add(employee);
	}

	public ArrayList<Employee> getEmployeeList() {
		return this.employeeList;
	}

	public Employee findEmployee(int idx) {
		return this.employeeList.get(idx);
	}

	public boolean SignUp(Employee emlpoyee) {
		this.employeeList.add(emlpoyee);
		return true;
	}
}
