package RunClient;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

import Contract.Contract;
import DataList.Lists;
import Employee.Employee;
import global.Util;

public class PManager {

	private Employee employee;
	private Lists lists;

	public PManager(Employee employee, Lists lists) {

		this.lists = lists;
		this.employee = employee;

		// Manager 계약 관리자
		ManagerMain();
	}

	public void ManagerMain() {
		boolean check = false;

		while (!check) {
			System.out.println("---------------Manager---------------");
			System.out.println("1. 보험금 미납자 리스트 확인하기.");
			System.out.println("2. 만기계약 대상자를 관리한다.");
			int select = Util.IntReader("3. exit");

			if (select == 1) {
				// 여기서 value는 임시변수로 나중에 이어갈 기능에 이어가면됨
				ShowPayNotList();
			} else if (select == 2) {
				ManagementContract();
			} else if (select == 3) {
				check = true;
			} else {
				System.out.println("Select Error retry");
			}
		}
	}

	public int ShowPayNotList() {

		for (int i = 0; i < this.lists.getContractList().size(); i++) {
			if (this.lists.getContractList().get(i).isCheckPay() == false) {
				System.out.println(this.lists.getContractList().get(i).toStringAll());
			}
		}
		int selectContract = Util.IntReader("미납 이메일 보낼 사용자 번호를 입력하세요.");
		sendEmail(selectContract);
		return selectContract;
	}

	public int ManagementContract() {
		// 만기계약 알아서하기 개귀찮음
		// 2번 클릭시
		// 리스트나오고
		int idx;
		for (int i = 0; i < this.lists.getContractList().size(); i++) {
			if (this.lists.getContractList().get(i).getCreated().isAfter(LocalDate.now())) {
				System.out.println(this.lists.getContractList().get(i).toStringAll());
			}
		}
		return idx = Util.IntReader("보험 연장 시킬 사용자 번호를 입력하세요.");

	}

	public boolean SendEmail(Contract contract, int idx) {
		// 컨트랙트 안에 고객정보 가지고 보내기

		System.out.println(lists.getUserList().findUser(idx).getEmail() + "로 전송이 완료되었습니다.");
		// sendEamil 알아서
		return true;
	}
	
	public Lists getLists() {
		return this.lists;
	}
} 