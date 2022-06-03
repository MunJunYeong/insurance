package Employee;

import java.util.List;
import Dao.EmployeeDao;

public class EmployeeListImpl implements EmployeeList {
	private EmployeeDao employeeDao = new EmployeeDao();
	
	public EmployeeListImpl() {
	}

	
	@Override
	public List<Employee> getEmployeeList() {
		List<Employee> employeeList = employeeDao.getEmployeeList();
		return employeeList;
	}

	@Override
	public boolean SignUp(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override	
	public boolean deleteEmployee(Long employeeIdx) {
		return employeeDao.deleteEmployee(employeeIdx);
	}
}
