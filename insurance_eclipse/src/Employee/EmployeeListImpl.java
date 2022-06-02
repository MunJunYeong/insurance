package Employee;

import java.sql.ResultSet;
import java.util.ArrayList;

import Dao.EmployeeDao;
import User.UserListImpl;
import global.Util;

public class EmployeeListImpl implements EmployeeList {

	private EmployeeDao employeeDao = new EmployeeDao();
	
	public EmployeeListImpl() {
	}

	public ResultSet getEmployeeList() {
		ResultSet rs = employeeDao.getEmployeeList();
		return rs;
	}

	public ResultSet findEmployee(Long employeeIdx) {
		ResultSet rs = employeeDao.findOneEmployee(employeeIdx);
		return rs;
	}

	public boolean SignUp(Employee employee) {
		return employeeDao.addEmployee(employee);
	}
	
	public boolean deleteEmployee(Long employeeIdx) {
		return employeeDao.deleteEmployee(employeeIdx);
	}
}
