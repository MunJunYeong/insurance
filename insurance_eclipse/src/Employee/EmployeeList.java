
package Employee;

import java.sql.ResultSet;

public interface EmployeeList {

	public boolean SignUp(Employee employee);
	public ResultSet getEmployeeList();
	public ResultSet findEmployee(Long employeeIdx);
	public boolean deleteEmployee(Long employeeIdx);
}
