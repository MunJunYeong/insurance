package RunClient;

import java.util.ArrayList;

import DataList.Lists;
import Employee.Employee;
import global.Util;

public class PUW {

	private Employee employee;
	private Lists lists;
	private String UWRole; // 알아서 가져가기 인수정책

	public PUW(Employee employee, Lists lists) {

		this.employee = employee;
		this.lists = lists;

		// UW
		UWMain();
	}

	public void UWMain() {
		boolean check = false;
		while (!check) {
			System.out.println("---------------UW---------------");
			System.out.println("1. 인수 정책 수립하기");
			System.out.println("2. 인수 검사 리스트 확인 / 승인 하기");
			int select = Util.IntReader("3.exit");

			if (select == 1) {
				this.UWRole = Util.StringReader("인수정책 내용을 입력하세요 : ");
			} else if (select == 2) {
				checkUW();
			} else if (select == 3) {
				check = true;
			} else {
				System.out.println("Select Error retry");
			}
		}
	}

	public boolean checkUW() {
		System.out.println("---------------UW LIST---------------");
//		for (int i = 0; i < this.lists.getContractList().getContractList().size(); i++) {
//			if (this.lists.getContractList().findContract(i).isCheckUW() == false) {
//				System.out.println(this.lists.getContractList().findContract(i).getInfo());
//			}
//		}
		// System.out.println("---------------CHECK UW---------------");
		int idx = Util.IntReader("승인할 계약번호를 입력하세요.");
		int Check = Util.IntReader("승인하시겠습니까? 승인시 1 미승인시 2");
//		if (Check == 1) {
//			this.lists.getContractList().findContract(idx).setCheckUW(true);
//		} else {
//			// 미승인
//		}
		return true;
	}

	public Lists getLists() {
		return this.lists;
	}
}
