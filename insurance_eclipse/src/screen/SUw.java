package screen;

import java.util.List;

import contract.Contract;
import dataList.Lists;
import employee.Employee;
import global.Util;
import insurance.Travel;
import uwRule.UwRule;

public class SUw {

	private Employee employee = new Employee();
	private Lists lists;

	public SUw(Employee employee, Lists lists) {

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
			System.out.println("2. 인수 정책 리스트 확인");
			System.out.println("3. 인수 검사 리스트 확인 / 승인 하기");
			int select = Util.IntReader("4. 로그아웃");

			switch (select) {
			case 1:
				addUwRule();
				break;
			case 2:
				getUwRule();
				break;
			case 3:
				checkUW();
				break;
			case 4:
				check = true;
				break;
			default:
				System.out.println("Select Error retry");
				break;
			}
		}
	}
	private void addUwRule() {
		UwRule uwRule = new UwRule();
		uwRule.setTitle(Util.StringReader("인수정책 제목: "));
		uwRule.setContent(Util.StringReader("인수정책 내용: "));
		uwRule.setEmployeeIdx(this.employee.getEmployeeIdx());
		this.lists.addUwRule(uwRule);
	}

	public boolean getUwRule() {
		System.out.println("---------------UWRule LIST---------------");
		List<UwRule> uwRuleList = this.lists.getUwRuleList();
		if (uwRuleList.size() == 0) {
			System.out.println("등록된 인수 정책이 없습니다.");
			return false;
		}
		System.out.println("[정책 번호]   " + "[정책 제목]   "+ "[정책 내용]   "+ "[직원 번호]");
		for (UwRule temp : uwRuleList) {
			String message = "   " + 
					temp.getUwRuleIdx() + "         " + 
					temp.getTitle() + "         "+
					temp.getContent() + "         "+
					temp.getEmployeeIdx() + "\n";
			System.out.println(message);
		}
		return true;
	
	}
	public boolean checkUW() {
		System.out.println("---------------UW LIST---------------");
		List<Contract> contractList = this.lists.getUwContract();
		if (contractList.size() == 0) {
			System.out.println("인수 검사할 계약이 없습니다.");
			return false;
		}
		System.out.println("[계약번호]   " + "[고객번호]");
		for (Contract temp : contractList) {
			String message = "   " + temp.getContractIdx() + "         " + temp.getUserIdx();
			System.out.println(message);
			System.out.println("[제안서] : " + temp.getSuggestion());
			System.out.println("[청약서] : " + temp.getSubscription());
		}
		System.out.println("---------------CHECK UW---------------");
		int contractIdx = Util.IntReader("승인할 계약번호를 입력하세요.");
		if (Util.IntReader("승인하시겠습니까? 승인(1) 미승인(2)") == 1) {
			Contract contract = null;
			for (Contract temp : contractList) {
				if (temp.getContractIdx() == contractIdx) {
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
