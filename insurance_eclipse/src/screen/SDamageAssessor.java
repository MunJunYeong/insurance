package screen;

import java.util.List;

import accident.Accident;
import dataList.Lists;
import employee.Employee;
import global.Util;

public class SDamageAssessor {

	private Lists lists;
	private Employee employee;

	public SDamageAssessor(Employee employee, Lists lists) {
		this.lists = lists;
		this.employee = employee;
		// DamageAssessor 손해 관리 직원
		DamageAssessorMain();
	}

	public void DamageAssessorMain() {
		boolean check = false;
		while (!check) {
			System.out.println("---------------DamageAssessor---------------");
			System.out.println("1. 사고 리스트 확인하기");
			System.out.println("2. 사고 손해 배상금 책정하기");
			int select = Util.IntReader("3. 로그아웃 하기");
			
			switch(select) {
			case 1:
				showAccidentList();
				break;
			case 2:
				modifyCompensationPrice();
				break;
			case 3:
				check = true;
				break;
			default :
				System.out.println("유효한 입력 값을 입력해주세요.");
				break;
			}
		}
	}
	private void modifyCompensationPrice() {
		List<Accident> accidentList = this.lists.getAccidentList();
		if(accidentList.size()== 0) {
			System.out.println("손해 배상금을 책정 할 사고 내역이 없습니다."); return;
		}
		Accident accident = null;
		int accidentIdx;
		boolean flag = false;
		accidentIdx = Util.IntReader("금액을 책정할 사고 번호를 입력해주세요.(뒤로가기 0)");
		while(!flag) {
			if(accidentIdx == 0) {
				flag =true; break;
			}
			for(Accident temp : accidentList) {
				if(temp.getAccidentIdx() == accidentIdx) {
					accident = temp;
					flag = true;
					break;
				}
			}
			if(!flag) {
				accidentIdx = Util.IntReader("존재하지 않는 사고 번호입니다. 다시 입력해주세요.(뒤로가기 0)");
			}
		}
		if(accidentIdx == 0) return;
		//사고 내용을 보여주고
		System.out.println(accident.getAccidentIdx() + "   " + accident.getContent() + "    " + accident.getDamagePrice() + accident.getAccidenttype());
		System.out.println();
		int price = Util.IntReader("책정한 보상 금액을 입력해주세요.");
		if(this.lists.modifyCompensationPrice(accident.getAccidentIdx(), price)) {
			System.out.println(accident.getAccidentIdx() + "번의 사고 손해 금액 책정이 성공적으로 이루어졌습니다.");
			System.out.println();
		}
		
	}

	public void showAccidentList() {
		List<Accident> list = this.lists.getAccidentList();
		if(list.size()== 0) {
			System.out.println("접수된 사고 내역이 존재하지 않습니다."); return;
		}
		for(Accident accident : list) {
			if(accident.getCompensationPrice() == 0) {
				System.out.println(accident.getAccidentIdx() + "   " + 
						accident.getContent() + "   " + accident.getDamagePrice());
			}
		}
	}

	public Lists getLists() {
		return this.lists;
	}

}
