package DataList;

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
import Insurance.Car;
import Insurance.Fire;
import Insurance.Health;
import Insurance.InsuranceList;
import Insurance.InsuranceListImpl;
import Insurance.Travel;
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
	
	public List<User> getUserList() {
		return this.userList.getUserList();
	}
	public List<Fire> getFireList() {
		return this.insuranceList.getFireInsuranceList();
	}
	public List<Car> getCarList() {
		return this.insuranceList.getCarInsuranceList();
	}
	public List<Health> getHealthList() {
		return this.insuranceList.getHealthInsuranceList();
	}
	public List<Travel> getTravelList() {
		return this.insuranceList.getTravelInsuranceList();
	}
	public List<Employee> getEmployeeList() {
		return this.employeeList.getEmployeeList();
	}
	
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
	public boolean addCarInsurance(Car car) {
		return this.insuranceList.addCarInsurance(car);
	}
	public boolean addFireInsurance(Fire fire) {
		return this.insuranceList.addFireInsurance(fire);
	}
	public boolean addTravelInsurance(Travel travel) {
		return this.insuranceList.addTravelInsurnace(travel);
	}
	public boolean addHealthInsurance(Health health) {
		return this.insuranceList.addHealthInsurnace(health);
	}
	
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


	//제안서 청약서 체크
	public void modifyCheckSug(Contract contract) {
		contract.setCheckSug(true);
	}
	public void modifyCheckSub(Contract contract) {
		contract.setCheckSub(true);
	}


	public List<Contract> getUserContract(Long userIdx) {
		List<Contract> temp = new ArrayList<Contract>();
		for(Contract contract : this.contractList.getContractList()) {
			if(contract.getUserIdx() == userIdx)
				temp.add(contract);
		}
		return temp;
	}
	public List<Contract> getFinalContract() {
		List<Contract> temp = new ArrayList<Contract>();
		for(Contract contract : this.contractList.getContractList()) {
			if(contract.isCheckUw())
				temp.add(contract);
		}
		return temp;
	}
	public List<Contract> getCompleteContract() {
		List<Contract> temp = new ArrayList<Contract>();
//		for(Contract contract : this.contractList.getContractList()) {
//			if(contract.isCompleted())
//				temp.add(contract);
//		}
		return temp;
	}

	public void finishingContract(int contractIdx) {
		Contract contract;
		for(Contract temp : this.contractList.getContractList()) {
			if(temp.getContractIdx() == contractIdx)
				contract = temp;
		}
		//set 마지막 부분 
//		contract.set
	}
	





	

}
