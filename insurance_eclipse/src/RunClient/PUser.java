package RunClient;

import java.util.List;

import Accident.Accident;
import Contract.Contract;
import DataList.Lists;
import Insurance.Car;
import Insurance.Fire;
import Insurance.Health;
import Insurance.Travel;
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
			System.out.println("5. 계약금 납입하기");
			int select = Util.IntReader("6. 로그아웃하기");

			switch (select) {
			case 1:
				System.out.println("------제안서를 확인합니다------");
				long idx = -1;
				while (!idxCheck(idx)) {
					idx = CheckSuggestion(user.getUserIdx());
				}
				if (idx != -2) {
					System.out.println(idx + "번의 계약 제안서가 승인되었습니다.");
				}
				break;
			case 2:
				System.out.println("------청약서를 확인합니다------");
				long idx2 = -1;
				while (!idxCheck(idx2)) {
					idx2 = CheckSubscription(user.getUserIdx());
				}
				if (idx2 != -2) {
					System.out.println(idx2 + "번의 계약 제안서가 승인되었습니다.");
				}
				break;
			case 3:
				CreateAccident();
				break;
			case 4:
				CheckAccident();
				break;
			case 5:
				System.out.println("------미납된 계약를 확인합니다------");
				payContract();
				break;
			case 6:
				check = true;
				break;
			default:
				System.out.println("Select Error retry");
				break;
			}
		}
	}

	private void payContract() {
		List<Contract> contractList = this.lists.getCheckPayContract(this.user.getUserIdx());
		if(contractList.size()== 0) {
			System.out.println("납부하지 않은 계약이 없습니다."); System.out.println(); return;
		}
		for(Contract contract : contractList) {
			System.out.println("[계약 번호] : " + contract.getContractIdx() + "  [계약 금액] : " + contract.getFee());
		}
		long contractIdx = -1;
		boolean flag = false;
		contractIdx = (long) Util.IntReader("계약 금액을 납부할 계약 번호를 입력해주세요. 뒤로가기(0)");
		while(!flag) {
			if(contractIdx == 0) {
				flag= true; break;
			}
			for(Contract contract : contractList) {
				if(contract.getContractIdx() == contractIdx) {
					contractIdx = contract.getContractIdx();
					flag = true;
					break;
				}
			}
			if(!flag) contractIdx = Util.IntReader("존재하지 않는 계약 번호입니다. 다시 입력해주세요. 뒤로가기(0)");
		}
		if(contractIdx == 0) return;
		if(Util.IntReader("승인하시겠습니까? 승인(1) 미승인(아무 버튼)") == 1) {
			this.lists.modifyCheckPay(contractIdx);
			System.out.println(contractIdx +"번 계약의 계약금을 성공적으로 납부했습니다. 감사합니다!");
		}else {
			System.out.println("계약금을 납입을 취소합니다.");
		}
	}

	public long CheckSuggestion(Long userIdx) {
		List<Contract> contractList = this.lists.getUserSugContract(userIdx);
		if (contractList.size() == 0) {
			System.out.println("아직 보험 설계사로부터 받은 제안서가 존재하지 않습니다.");
			System.out.println();
			return -2;
		}
		System.out.println("계약번호  " + "고객번호   " + "제안서");
		for (Contract contract : contractList) {
			String message = contract.getContractIdx() + "      " + contract.getUserIdx() + "       "
					+ contract.getSuggestion();
			System.out.println(message);
		}
		// 여기서부터 제안서에 대한 승인 내용
		Contract contract = null;
		int contractIdx = 0;
		boolean flag = false;
		while (!flag) {
			contractIdx = Util.IntReader("승인하실 계약 번호를 입력해주세요(뒤로가기 0)");
			if (contractIdx == 0) {
				break;
			}
			for (Contract temp : contractList) {
				if (temp.getContractIdx() == contractIdx) {
					contract = temp;
					flag = true;
					break;
				}
			}
			if (contract == null)
				System.out.println("존재하지 않는 계약번호입니다. 다시 입력해주세요");
		}
		if (contractIdx == 0) {
			return -2;
		}
		int suggestionChoice = Util.IntReader("승인하시겠습니까? 승인(1) 미승인(2)");
		if (suggestionChoice == 1) {
			this.lists.modifyCheckSug(contract.getContractIdx());
			return contract.getContractIdx();
		} else if (suggestionChoice == 2) {
			System.out.println("미승인 처리 되었습니다.");
			return -1;
		} else {
			System.out.println("1또는2를 입력해주십시오.");
			return 0;
		}
	}

	public long CheckSubscription(Long userIdx) {
		List<Contract> contractList = this.lists.getUserSubContract(userIdx);
		if (contractList.size() == 0) {
			System.out.println("요청 온 청약서가 존재하지 않습니다.");
			System.out.println();
			return -2;
		}
		String message = null;
		System.out.println("계약번호  " + "고객번호   " + "청약서");
		for (Contract contract : contractList) {
			message = contract.getContractIdx() + "       " + contract.getUserIdx() + "       "
					+ contract.getSubscription();
			System.out.println(message);
		}
		// 여기서부터 청약서에 대한 승인 내용
		Contract contract = null;
		int contractIdx = 0;
		boolean flag = false;
		while (!flag) {
			contractIdx = Util.IntReader("승인하실 계약 번호를 입력해주세요(뒤로가기 0)");
			if (contractIdx == 0) {
				return -2;
			}
			for (Contract temp : contractList) {
				if (temp.getContractIdx() == contractIdx) {
					contract = temp;
					flag = true;
					break;
				}
			}
			if (contract == null)
				System.out.println("존재하지 않는 계약번호입니다. 다시 입력해주세요.");
		}
		int subscriptionChoice = Util.IntReader("승인하시겠습니까? 승인(1) 미승인(2)");
		if (subscriptionChoice == 1) {
			System.out.println("승인 처리 되었습니다.");
			this.lists.modifyCheckSub(contract.getContractIdx());
			return contract.getContractIdx();
		} else if (subscriptionChoice == 2) {
			System.out.println("미승인 처리 되었습니다.");
			return -1;
		} else {
			System.out.println("1또는2를 입력해주십시오.");
			return 0;
		}
	}

	public boolean CreateAccident() {
		System.out.println("사고 신고 내용을 입력해주세요.");
		Accident accident = new Accident();
		accident.setUserIdx(this.user.getUserIdx());
		boolean flag = false;
		List<?> insuranceList = null;
		while (!flag) {
			int type = Util.IntReader("화재(1), 자동차(2), 생명(3), 여행(4)");
			switch (type) {
			case 1:
				insuranceList = this.lists.getUserFireList(this.user.getUserIdx());
				accident.setAccidenttype("Fire");
				if (insuranceList == null)
					flag = true;
				break;
			case 2:
				insuranceList = this.lists.getUserCarList(this.user.getUserIdx());
				accident.setAccidenttype("Car");
				flag = true;
				break;
			case 3:
				insuranceList = this.lists.getUserHealthList(this.user.getUserIdx());
				accident.setAccidenttype("Health");
				flag = true;
				break;
			case 4:
				insuranceList = this.lists.getUserTravelList(this.user.getUserIdx());
				accident.setAccidenttype("Travel");
				flag = true;
				break;
			default:
				System.out.println("올바른 번호를 입력해주세요.");
				break;
			}
		}
		if (insuranceList == null) {
			System.out.println("고객님께서 가입한 보험이 존재하지 않아 사고 신고가 불가능합니다.");
			return false;
		}
		// 사실 여기서 보험 리스트를 보여주는 것이 옳으나 그냥 제일 위에있는 보험으로 자동 연계되어 들어간다 ?

		accident.setContent(Util.StringReader("사고 내용: "));
		accident.setDamagePrice(Util.IntReader("피해 금액: "));
		// 이 고객으로 부터 가입한 보험 가지고오기
		this.lists.addAccident(accident);
		return true;
	}

	public boolean CheckAccident() {
		System.out.println("------접수한 사고에 대한 결과입니다------");
		System.out.println();
		System.out.println("피해 금액 보상안 산정 중인 사고 내역");
		System.out.println();
		System.out.println("처리된 신고 내역");
		System.out.println();
		System.out.println("소송한 신고 내역");

//      long accidentidx = 0;
//      for (int i = 0; i < this.lists.getAccidentList().getAccidentList().size(); i++) {
//         if (this.lists.getAccidentList().findAccident(i).isCheck() == true
//               && this.lists.getAccidentList().findAccident(i).getUserIdx() == this.user.getUserIdx()) {
//            System.out.println(this.lists.getAccidentList().findAccident(i).getInfo());
//            accidentidx = this.lists.getAccidentList().findAccident(i).getAccidentIdx();
//
//         }
//      }
//      if (Util.IntReader("소송하시겠습니까? 소송 1 미소송 2") == 1) {
//         this.lists.getAccidentList().findAccident(Math.toIntExact(accidentidx)).setLowsuit(true);
//      }
		return true;
	}

	public Lists getLists() {
		return this.lists;
	}

	private boolean idxCheck(long idx) {
		if (idx == -1)
			return false;
		return true;
	}
}