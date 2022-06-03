package RunClient;

import java.util.List;
import java.util.StringTokenizer;

import Accident.Accident;
import Contract.Contract;
import DataList.Lists;
import User.User;
import global.Util;

public class PUser {

	private User user;
	private Lists lists;

	public PUser(User user, Lists lists) {
		this.lists = new Lists();
		this.user = user;
		// User
		UserMain();
	}

	public void UserMain() {
		boolean check = false;

		System.out.println("---------------USER---------------");
		System.out.println();
		System.out.println(this.user.getName() + "님이 접속했습니다.");
		while (!check) {
			System.out.println("1. 제안서 확인/승인하기");
			System.out.println("2. 청약서 확인/승인하기");
			System.out.println("3. 사고 신고 하기");
			System.out.println("4. 사고 결과 확인/소송 하기");
			int select = Util.IntReader("5. 로그아웃하기");
			
			switch(select) {
				case 1:
					System.out.println("------제안서를 확인합니다------");
					long idx = CheckSuggestion(user.getUserIdx());
					if(idx != -1) {
						System.out.println(idx + "번의 계약 제안서가 승인되었습니다.");
					}
					break;
				case 2: 
					System.out.println("------청약서를 확인합니다------");
					long idx2 = CheckSubscription(user.getUserIdx());
					if(idx2 != -1) {
						System.out.println(idx2 + "번의 계약 청약서가 승인되었습니다.");
					}
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

	public long CheckSuggestion(Long userIdx) {
		List<Contract> contractList = this.lists.getUserContract(userIdx);
		if(contractList.size() == 0) {
			System.out.println("아직 보험 설계사로부터 받은 제안서가 존재하지 않습니다.");
			System.out.println();
			return -1;
		}
		for(Contract contract : contractList) {
			String message = contract.getContractIdx() + "     " + contract.getUserIdx() + "     " + contract.getSuggestion();
			System.out.println(message);
		}
		//여기서부터 제안서에 대한 승인 내용
		int contractIdx = Util.IntReader("승인하실 계약 번호를 입력해주세요");
		if (Util.IntReader("승인하시겠습니까? 승인(1) 미승인(2)") == 1) {
			Contract contract = new Contract();
			for(Contract temp : contractList) {
				if(temp.getContractIdx() == contractIdx) {
					contract = temp;
				}
			}
			this.lists.modifyCheckSug(contract);
			return contract.getContractIdx();
		}else {
			return -1;
		}
	}
	public long CheckSubscription(Long userIdx) {
		List<Contract> contractList = this.lists.getUserContract(userIdx);
		if(contractList.size() == 0) {
			System.out.println("요청 온 청약서가 존재하지 않습니다.");
			System.out.println();
			return -1;
		}
		String message = null;
		for(Contract contract : contractList) {
			message = contract.getContractIdx() + "     " + contract.getUserIdx() + "     " + contract.getSubscription();
			System.out.println(message);
		}
		//여기서부터 청약서에 대한 승인 내용
		int contractIdx = Util.IntReader("승인하실 계약 번호를 입력해주세요");
		if (Util.IntReader("승인하시겠습니까? 승인(1) 미승인(2)") == 1) {
			Contract contract = null;
			for(Contract temp : contractList) {
				if(temp.getContractIdx() == contractIdx) {
					contract = temp;
				}
			}
			this.lists.modifyCheckSub(contract);
			return contract.getContractIdx();
		}else {
			return -1;
		}
	}

	public boolean CreateAccident() {
		System.out.println("사고 신고 내용을 입력해주세요.");
		Accident accident = new Accident();
		accident.setUserIdx(this.user.getUserIdx());
		accident.setAccidenttype(Util.StringReader("사고 종류: "));
		accident.setContent(Util.StringReader("사고 내용: "));
		accident.setDamagePrice(Util.IntReader("피해 금액: "));
		this.lists.addAccident(accident);
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