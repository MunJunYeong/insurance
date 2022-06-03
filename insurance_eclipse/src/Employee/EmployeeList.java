package Employee;


import java.util.List;

public interface EmployeeList {
	public boolean SignUp(Employee employee);
	public List<Employee> getEmployeeList();
	public boolean deleteEmployee(Long employeeIdx);
//	public boolean updateEmployee();

}