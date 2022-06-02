package DataList;

import Accident.AccidentList;
import Accident.AccidentListImpl;
import Contract.ContractList;
import Contract.ContractListImpl;
import Employee.EmployeeList;
import Employee.EmployeeListImpl;
import Insurance.InsuranceList;
import Insurance.InsuranceListImpl;
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
	
	public void ConnectDB() {
				
	}
	
	public UserList getUserList() {
		return this.userList;
	}
	
	public EmployeeList getEmployeeList() {
		return this.employeeList;
	}
	
	public AccidentList getAccidentList() {
		return this.accidentList;
	}
	
	public ContractList getContractList() {
		return this.contractList ;
		
	}
	public InsuranceList getInsuranceList() {
		return this.insuranceList;
	}
	
}
