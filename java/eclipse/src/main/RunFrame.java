package main;

import DataList.Lists;
import Employee.Employee;
import Employee.EmployeeListImpl;
import RunClient.PAccidentManager;
import RunClient.PDamageAssessor;
import RunClient.PDesigner;
import RunClient.PLogin;
import RunClient.PManager;
import RunClient.PMarketer;
import RunClient.PSalesman;
import RunClient.PSignUp;
import RunClient.PUW;
import RunClient.PUser;
import User.User;
import User.UserListImpl;
import global.Util;

public class RunFrame {

	private Lists lists;

	private User user;
	private Employee employee;

	public RunFrame() {
		this.lists = new Lists();
		boolean start = false;

		while (!start) {
			int select = Util.IntReader("1. 로그인 화면 \n2. 회원가입 \n3. exit");
			if (select == 1) {
				PLogin pLogin = new PLogin(this.lists);
				////////////////////// 사용자 장착//////////////////////
				if(pLogin.getType() == null) {
					System.out.println("일치하는 회원정보가 존재하지 않습니다.");
				}else if (pLogin.getType().equals("user")) {
					this.user = pLogin.getUser();
					runUser(this.user, this.lists);
				} else if (pLogin.getType().equals("employee")) {
					this.employee = pLogin.getEmployee();
					runEmployee(this.employee, this.lists);
				} else {
					System.out.println("not match account");
				}
				/////////////////////////////////////////////////////

			} else if (select == 2) {
				PSignUp pSignUp = new PSignUp(this.lists);
				PLogin pLogin = new PLogin(this.lists);
				////////////////////// 사용자 장착//////////////////////
				if (pLogin.getType().equals("user")) {
					this.user = pLogin.getUser();
					runUser(this.user, this.lists);
				} else if (pLogin.getType().equals("employee")) {
					this.employee = pLogin.getEmployee();
					runEmployee(this.employee, this.lists);
				} else {
					System.out.println("not match account");
				}
				/////////////////////////////////////////////////////
			} else {
				start = true;
			}
		}

	}

	////////////////////// Run User//////////////////////
	public boolean runUser(User user, Lists lists) {
		PUser pUser = new PUser(user, lists);
		return true;
	}

	////////////////////// Run Employee//////////////////////
	public boolean runEmployee(Employee employee, Lists lists) {
		// 케이스문 알아서 바꾸

		String role = employee.getRole();
		switch (role) {
		case "AccidentManager":
			PAccidentManager accidentManager = new PAccidentManager(employee,lists);
			this.lists = accidentManager.getLists(); //DB저장 
			return true;
		case "DamageAssessor":
			PDamageAssessor damageAssessor = new PDamageAssessor(employee, lists);
			this.lists = damageAssessor.getLists();
			return true;
		case "Designer":
			PDesigner designer = new PDesigner(employee, lists);
			this.lists = designer.getLists();
			return true;
		case "Manager":
			PManager manager = new PManager(employee, lists);
			this.lists = manager.getLists();
			return true;
		case "Marketer":
			PMarketer marketer = new PMarketer(employee, lists);
			this.lists = marketer.getLists();
			return true;
		case "Salesman":
			PSalesman salesman = new PSalesman(employee, lists);
			this.lists = salesman.getLists();
			return true;
		case "UW":
			PUW uw = new PUW(employee, lists);
			this.lists = uw.getLists();
			return true;
		default:
			System.out.println("잘못된 role 입니다.");
		}
		return false;
	}
}