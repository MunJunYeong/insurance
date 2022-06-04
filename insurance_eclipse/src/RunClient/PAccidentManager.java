package RunClient;

import java.util.List;

import Accident.Accident;
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
			System.out.println();
			System.out.println("1. 사고 리스트 확인 및 승인하기");
			int select = Util.IntReader("2. 로그아웃 하기");
			switch(select) {
			case 1: 
				CheckAccidentList();
				break;
			case 2:
				check = true;
				break;
			default :
				System.out.println("Select Error retry");
			}
		}
	}
	
	public boolean CheckAccidentList() {
		List<Accident> accidentList = this.lists.getCheckAccidentList();
		if(accidentList.size() == 0) {
			System.out.println("확인할 사고 내역이 없습니다."); 
			return false;
		}
		//이 부분 꾸미기 
		for(Accident accident : accidentList) {
			System.out.println(accident.toStringAll());
		}
		
		boolean flag = false;
		Accident accident = null;
		while(!flag) {
			int accidentNum = Util.IntReader("사고 번호를 입력해주세요.");
			accident = this.lists.getAccident(accidentNum);
			if(accident == null) {
				System.out.println("사고 번호에 해당하는 사고 신고 내역이 없습니다. 다시 입력해주세요.");
			}else {
				flag = true;
				System.out.println(accident.getAccidenttype()  + " " + accident.getContent()+ 
						" " + accident.getAccidentDate()+ " "  + accident.getDamagePrice());
			}
		}
		
		if (Util.IntReader("승인/거부 여부를 정하세요.(승인 시 1, 거부 시 2)") == 1) {
			if(this.lists.modifyCheckAccident(accident.getAccidentIdx())) {
				System.out.println(accident.getAccidentIdx() +"번의 사고가 성공적으로 승인되었습니다.");
				System.out.println("해당 사고가 손해 사정사에게 안전하게 전달되었습니다.");
			}
		} else {
			System.out.println(accident.getAccidentIdx() + "번의 사고는 거부되었습니다.");
		}
		return true;
	}
	
	public Lists getLists(Long accidentIdx) {
		return this.lists;
	}
	
	public Lists getLists() {
		return this.lists;
	}
}
