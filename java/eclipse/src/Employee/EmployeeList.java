
package Employee;

import java.util.ArrayList;

public interface EmployeeList {

	public boolean SignUp(Employee emlpoyee);
	
	public ArrayList<Employee> getEmployeeList();
	
	public Employee findEmployee(int idx);
}
