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
import Insurance.Insurance;
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
	public List<Accident> getAccidentList() {
		return this.accidentList.getAccidentList();
	}
	
	// 보험 list 가져오기
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
	
	//회원가입
	public boolean addEmployee(Employee employee) {
		return this.employeeList.SignUp(employee);
	}
	public boolean addUser(User user) {
		return this.userList.SignUp(user);
	}
	//사고추가
	public boolean addAccident(Accident accident) {
		return this.accidentList.createAccident(accident);
	}
	//계약 추가
	public boolean addContract(Contract contract) {
		return this.contractList.createContract(contract);
	}
	// 보험 추가
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
	
	// Contract method 수정
	public void modifyCheckSug(Long contractIdx) {
		this.contractList.modifyCheckSug(contractIdx);
	}
	public void modifyCheckSub(Contract contract) {
		this.contractList.modifyCheckSub(contract.getContractIdx());
	}
	//UW 체크
	public void modifyCheckUw(Contract contract) {
		this.contractList.modifyCheckUw(contract.getContractIdx());
	}
	public void modifyCompleted(Long contractIdx) {
		this.contractList.modifyCompleted(contractIdx);
//		this.contractList.cacluateFee(contractIdx);
	}
	public boolean modifyCheckAccident(Long accidentIdx) {
		return this.accidentList.modifyCheckAccident(accidentIdx);
	}
	public boolean modifyCompensationPrice(Long accidentIdx, int price) {
		return this.accidentList.modifyCompensationPrice(accidentIdx, price);
	}


	// Contract 가져오는 method
	public List<Contract> getUserContract(Long userIdx) {
		List<Contract> temp = new ArrayList<Contract>();
		for(Contract contract : this.contractList.getContractList()) {
			// 이미 true 1의 값을 가지고 있는데도 안먹힘
			if(contract.getUserIdx() == userIdx && !contract.isCheckSug())
				temp.add(contract);
		}
		return temp;
	}
	public List<Contract> getUwContract() {
		List<Contract> temp = new ArrayList<Contract>();
		for(Contract contract : this.contractList.getContractList()) {
			if(contract.isCheckSub() && contract.isCheckSub() && !contract.isCheckUw())
				temp.add(contract);
		}
		return temp;
	}
	public List<Contract> getFinalContract() {
		List<Contract> temp = new ArrayList<Contract>();
		for(Contract contract : this.contractList.getContractList()) {
			if(contract.isCheckUw() && !contract.isCompleted())
				temp.add(contract);
		}
		return temp;
	}
	public List<Contract> getCompleteContract() {
		List<Contract> temp = new ArrayList<Contract>();
		for(Contract contract : this.contractList.getContractList()) {
			if(contract.isCompleted())
				temp.add(contract);
		}
		return temp;
	}

	public List<Accident> getCheckAccidentList() {
		List<Accident> temp = new ArrayList<Accident>();
		for(Accident accident : this.accidentList.getAccidentList()) {
			if(!accident.isCheckAccident()) {
				temp.add(accident);
			}
		}
		return temp;
	}
	public Accident getAccident(long accidentIdx) {
		Accident temp = null;
		for(Accident accident : this.accidentList.getAccidentList()) {
			if(accident.getAccidentIdx() == accidentIdx) {
				temp = accident;
			}
		}
		return temp;
	}

	
	//사고 접수할 때 해당 고객이 가입한 보험 확인
	@SuppressWarnings("null")
	public List<?> getUserFireList(Long userIdx) {
		List<Fire> res = null;
		List<Contract> list = this.contractList.getContractList();
		for(Contract contract : list) {
			if(contract.getUserIdx() == userIdx) {
				List<Fire> insuranceList = this.insuranceList.getFireInsuranceList();
				for(Fire fire : insuranceList) {
					if(fire.getInsuranceIdx() == contract.getInsuranceIdx()) {
						res.add(fire);
					}
				}
			}
		}
		return res;
	}
	@SuppressWarnings("null")
	public List<?> getUserCarList(Long userIdx) {
		List<Car> res = null;
		List<Contract> list = this.contractList.getContractList();
		for(Contract contract : list) {
			if(contract.getUserIdx() == userIdx) {
				List<Car> insuranceList = this.insuranceList.getCarInsuranceList();
				for(Car car : insuranceList) {
					if(car.getInsuranceIdx() == contract.getInsuranceIdx()) {
						res.add(car);
					}
				}
			}
		}
		return res;
	}
	@SuppressWarnings("null")
	public List<?> getUserHealthList(Long userIdx) {
		List<Health> res = null;
		List<Contract> list = this.contractList.getContractList();
		for(Contract contract : list) {
			if(contract.getUserIdx() == userIdx) {
				List<Health> insuranceList = this.insuranceList.getHealthInsuranceList();
				for(Health health : insuranceList) {
					if(health.getInsuranceIdx() == contract.getInsuranceIdx()) {
						res.add(health);
					}
				}
			}
		}
		return res;
	}

	@SuppressWarnings("null")
	public List<?> getUserTravelList(Long userIdx) {
		List<Travel> res = null;
		List<Contract> list = this.contractList.getContractList();
		for(Contract contract : list) {
			if(contract.getUserIdx() == userIdx) {
				List<Travel> insuranceList = this.insuranceList.getTravelInsuranceList();
				for(Travel travel : insuranceList) {
					if(travel.getInsuranceIdx() == contract.getInsuranceIdx()) {
						res.add(travel);
					}
				}
			}
		}
		return res;
	}


}
