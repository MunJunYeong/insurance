package RunClient;

import java.util.List;

import Contract.Contract;
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
			int select = Util.IntReader("3. 로그아웃");
			
			switch(select) {
			case 1:
				this.UWRole = Util.StringReader("인수정책 내용을 입력하세요 : ");
				break;
			case 2:
				checkUW();
				break;
			case 3:
				check = true;
				break;
			default:
				System.out.println("Select Error retry");
				break;
			}
		}
	}

	public boolean checkUW() {
		System.out.println("---------------UW LIST---------------");
		List<Contract> contractList = this.lists.getUwContract();
		if(contractList.size()== 0) {
			System.out.println("인수 검사할 계약이 없습니다."); return false;
		}
		for(Contract temp : contractList) {
			String message = temp.getContractIdx() + "     " + temp.getUserIdx() + "     " + temp.getSuggestion();
			System.out.println(message);
		}
		System.out.println("---------------CHECK UW---------------");
		int contractIdx = Util.IntReader("승인할 계약번호를 입력하세요.");
		if (Util.IntReader("승인하시겠습니까? 승인(1) 미승인(2)") == 1) {
			Contract contract = null;
			for(Contract temp : contractList) {
				if(temp.getContractIdx() == contractIdx) {
					contract = temp;
				}
			}
			this.lists.modifyCheckUw(contract.getContractIdx());
			System.out.println(contract.getContractIdx() + "번 계약의 인수검사가 성공적으로 수행되었습니다.");
			System.out.println();
			return true;
		}
		return false;
	}

	public Lists getLists() {
		return this.lists;
	}
}
