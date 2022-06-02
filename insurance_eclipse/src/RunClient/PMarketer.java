package RunClient;

import java.util.ArrayList;

import DataList.Lists;
import Employee.Employee;
import global.Util;

public class PMarketer {

	private Employee employee;
	private Lists lists;
	private ArrayList<String> insentiveList; // 임시

	public PMarketer(Employee employee, Lists lists) {

		this.lists = lists;
		this.employee = employee;
		this.insentiveList = new ArrayList<String>();

		MarketerMain();
	}

	public void MarketerMain() {
		boolean check = false;
		while (!check) {
			System.out.println("---------------Marketer---------------");
			System.out.println("1.인센티브 기준 수립하기");
			System.out.println("2.인센티브 기준 확인하기");
			System.out.println("3.직원 리스트 확인하기");
			int select = Util.IntReader("4. exit");

			if (select == 1) {
				CreateInsentive();
			} else if (select == 2) {
				CheckInsentive();
			} else if (select == 3) {
				CheckEmployeeList();
			} else if (select == 4) {
				check = true;
			} else {
				System.out.println("Select Error retry");
			}
		}
	}

	public boolean CheckEmployeeList() {
//		for (int i = 0; i < this.lists.getEmployeeList().getEmployeeList().size(); i++) {
//			System.out.println(this.lists.getEmployeeList().findEmployee(i).getInfo());
//		}
//
//		this.lists.getEmployeeList().findEmployee(Util.IntReader("직원 번호 입력하기"))
//				.setInsentive(Util.IntReader("인센티브 금액 입력하기"));
		return true; // 이 두개 반환
	}

	public boolean CreateInsentive() {
		this.insentiveList.add(Util.StringReader("기준을 입력해주세요."));
		return true;
	}

	public boolean CheckInsentive() {
		for (int i = 0; i < this.insentiveList.size(); i++) {
			System.out.println(this.insentiveList.get(i));
		}
		return true;
	}

	public Lists getLists() {
		return this.lists;
	}
}
