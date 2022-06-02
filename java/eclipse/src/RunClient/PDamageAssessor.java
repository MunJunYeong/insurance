package RunClient;

import DataList.Lists;
import Employee.Employee;
import global.Util;

public class PDamageAssessor {

	private Lists lists;
	private Employee employee;

	public PDamageAssessor(Employee employee, Lists lists) {

		this.lists = lists;
		this.employee = employee;

		// DamageAssessor 손해 관리 직원
		DamageAssessorMain();
	}

	public void DamageAssessorMain() {
		boolean check = false;
		while (!check) {
			System.out.println("---------------Marketer---------------");
			int select = Util.IntReader("1. 사고 리스트 확인하기");
			if (select == 1) {
				Handleling();
			} else if (select == 2) {
				check = true;
			} else {
				System.out.println("Select Error retry");
			}
		}
	}

	public boolean Handleling() {
		for (int i = 0; i < this.lists.getAccidentList().getAccidentList().size(); i++) {
			System.out.println(this.lists.getAccidentList().findAccident(i));
		}
		this.lists.getAccidentList().findAccident(Util.IntReader("사고 번호를 입력해주세요."))
				.setCompensationPrice(Util.IntReader("보상 금액을 입력해주세요."));
		return true;
	}

	public Lists getLists() {
		return this.lists;
	}

}
