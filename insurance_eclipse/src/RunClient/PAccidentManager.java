package RunClient;

import DataList.Lists;
import Employee.Employee;
import global.Util;

public class PAccidentManager {

	private Employee employee;
	private Lists lists;

	public PAccidentManager(Employee employee, Lists lists) {
		this.lists = lists;
		this.employee = employee;
		AccidentManagerMain();

	}
	public void AccidentManagerMain() {
		boolean check = false;
		while(!check) {
			System.out.println("---------------AccidentManager---------------");
			// AccidentManager 손해 관리 직원
			int select = Util.IntReader("1. 사고 리스트 확인하기");

			// 1번 클릭시
			if (select == 1) {
				CheckAccidentList();
				int accidentNum = Util.IntReader("사고 번호를 입력해주세요.");
				if (Util.IntReader("승인/거부 여부를 정하세요.(승인 시 1, 거부 시 2") == 1) {
//					this.lists.modifyCheckAccident((long) accidentNum);
				} else {
					System.out.println(accidentNum + "번의 사고는 거부되었습니다.");
				}
			} else if(select == 2 ) {
				check =true;
			}
			else {
				System.out.println("Select Error retry");
			}
		}
		
	}
	
	public boolean CheckAccidentList() {
		return true;
	}
	
	public Lists getLists() {
		return this.lists;
	}
}