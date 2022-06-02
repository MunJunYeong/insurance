package RunClient;

import Accident.Accident;
import DataList.Lists;
import User.User;
import global.Util;

public class PUser {

	private User user;
	private Lists lists;

	public PUser(User user, Lists lists) {

		this.user = user;
		// User
		UserMain();
	}

	public void UserMain() {
		boolean check = false;

		while (!check) {
			System.out.println("---------------USER---------------");
			System.out.println("1. 제안서 확인/승인하기");
			System.out.println("2. 청약서 확인/승인하기");
			System.out.println("3. 사고 신고 하기");
			System.out.println("4. 사고 결과 확인/소송 하기");
			int select = Util.IntReader("5. 로그아웃하기");
			
			switch(select) {
			case 1:
				System.out.println("------요청 온 제안서 내용입니다------");
				CheckSuggestion();
				break;
			case 2: 
				System.out.println("------요청 온 청약서 내용입니다------");
				CheckSubscription();
				break;
			case 3: 
				CreateAccident();
				break;
			case 4: 
				System.out.println("------접수한 사고에 대한 결과입니다------");
				CheckAccident();
				break;
			case 5: 
				check = true;
				break;
			default: 
				System.out.println("Select Error retry");
				break;
			}
		}
	}

	public boolean CheckSuggestion() {
//		Suggestion sg = this.lists.getContractList().findContractByUserId(this.user.getUserIdx()).getSuggestion();
//		System.out.println("보험종류 : " + sg.getInsuranceType() + "\n" + sg.getContent());
//		if (Util.IntReader("승인하시겠습니까? 승인시 1 미승인시 2") == 1) {
//			this.lists.getContractList().findContractByUserId(this.user.getUserIdx()).getSuggestion().setCheck(true);
//		}
		return true;
	}

	public boolean CheckSubscription() {
//		Subscription ss = this.lists.getContractList().findContractByUserId(this.user.getUserIdx()).getSubscription();
//		System.out
//				.println(ss.getInsuranceType() + "\n" + ss.getFee() + "\n" + ss.getMaxReward() + "\n" + ss.getPeriod());
//		if (Util.IntReader("승인하시겠습니까? 승인시 1 미승인시 2") == 1) {
//			this.lists.getContractList().findContractByUserId(this.user.getUserIdx()).getSubscription().setCheck(true);
//		}
		return true;
	}

	public boolean CreateAccident() {
//		System.out.println("qwewqe");
//		Accident accident = new Accident();
//		accident.setAccidentIdx((long) 0);
//		accident.setUserIdx(this.user.getUserIdx());
//		accident.setType(Util.StringReader("사고 종류: "));
//		accident.setContent(Util.StringReader("사고 내용: "));
//		accident.setDamagePrice(Util.IntReader("피해 금액: "));
//		accident.setUser(this.user);
//		// 담당 직원 set해야되는데 여기서 하는지는 모르겠다.
//		accident.setInsuranceIdx((long) this.lists.getInsuranceList().getInsuranceList().size());
//		this.lists.getAccidentList().CreateAccident(accident);
		return true;
	}

	public boolean CheckAccident() {
//		long accidentidx = 0;
//		for (int i = 0; i < this.lists.getAccidentList().getAccidentList().size(); i++) {
//			if (this.lists.getAccidentList().findAccident(i).isCheck() == true
//					&& this.lists.getAccidentList().findAccident(i).getUserIdx() == this.user.getUserIdx()) {
//				System.out.println(this.lists.getAccidentList().findAccident(i).getInfo());
//				accidentidx = this.lists.getAccidentList().findAccident(i).getAccidentIdx();
//
//			}
//		}
//		if (Util.IntReader("소송하시겠습니까? 소송 1 미소송 2") == 1) {
//			this.lists.getAccidentList().findAccident(Math.toIntExact(accidentidx)).setLowsuit(true);
//		}
		return true;
	}

	public Lists getLists() {
		return this.lists;
	}

}