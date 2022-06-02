package RunClient;

import Contract.Contract;
import DataList.Lists;
import Employee.Employee;
import User.User;
import global.Util;

public class PSalesman {

	private Employee employee;
	private Lists lists;

	public PSalesman(Employee employee, Lists lists) {

		this.employee = employee;
		this.lists = lists;

		// SalesMan
		SalesmanMain();
	}

	public void SalesmanMain() {
		boolean check = false;
		while (!check) {
			System.out.println("---------------SalesMan---------------");
			System.out.println("1. 고객 리스트 확인하기");
			int select = Util.IntReader("2. 최종 계약 리스트 확인/승인하기");
			// 1번 클릭시.
			if (select == 1) {
				CheckUserList();
			} else if (select == 2) {
				ShowFinalContract();
			} else if (select == 3) {
				check = true;
			} else {
				System.out.println("Select Error retry");
			}
		}
	}

	// 1번 클릭시
	public void CheckUserList() {

		System.out.println("---------------User List---------------");
		for (int i = 0; i < this.lists.getUserList().getUserList().size(); i++) {
			System.out.println(this.lists.getUserList().getInfo(i));
		}
		System.out.println("---------------Select---------------");
		// next
		Contract contract = new Contract();
//		contract.setUser(this.lists.getUserList().findUser(Util.IntReader("제안서를 작성하실 고객 번호를 입력해주세요.")));
//		contract.setEmployee(employee);

//		Suggestion suggestion = new Suggestion(this.lists.getContractList().getContractList().size(),
//				Util.StringReader("InsuranceType: "), Util.StringReader("제안서 내용을 입력해주세요."));
//		contract.setSuggestion(suggestion);

		//만약 청약서 제안서 따로 작성을 원한다면 제안서 저장후 리스트에 저장하는데 청약서 작성할때 만약 기존 작성이 잇다면 이어서 해야하고 없으면 청약서 작성을 막아야함.
	
			System.out.println("청약서 작성을 시작합니다.");
			// next
//			Subscription subscription = new Subscription(this.lists.getContractList().getContractList().size(),
//					Util.StringReader("InsuranceType: "), Util.IntReader("period: "), Util.IntReader("maxReward: "));
			
			
			double fee = Util.IntReader("기본 요금 : ");
			
			
//			if(contract.getInsurance().getType().equals("Car")) {
//				fee= fee*findCarRate(Util.IntReader("사고횟수"), Util.IntReader("차 대수"), Util.IntReader("차 가격"));
//			}else if(contract.getInsurance().getType().equals("Fire")) {
//				fee= fee*findFireRate(Util.IntReader("빌딩 개수: "),Util.IntReader("빌딩 가격: "));
//			}else if(contract.getInsurance().getType().equals("Health")) {
//				fee= fee*findHealthRate(Util.IntReader("건강 등급:"));
//			}else {
//				fee= fee*findTravelRate(Util.IntReader("여행국가등급: "), Util.IntReader("여행 기간(날짜수): "));
//			}
			System.out.println("요율 계산을 적용합니다.");
			
			
//			contract.getInsurance().setFee((int)fee);
//			contract.setSubscription(subscription);
			this.lists.getContractList().CreateContract(contract);
		
	}

	// 2번 클릭
	public void ShowFinalContract() {
		System.out.println("---------------Final Contract List---------------");
//		for (int i = 0; i < this.lists.getContractList().getContractList().size(); i++) {
//			if (this.lists.getContractList().findContract(i).isFinalContract() == true) {
//				System.out.println(this.lists.getContractList().findContract(i).getInfo());
//			}
//		}

		// 승인
		long idx = this.lists.getContractList().findContract(Util.IntReader("승인할 계약 번호를 입력하세요 : ")).getContractIdx();

//		this.lists.getContractList().findContract(Math.toIntExact(idx)).setFinishContract(true,
//				this.lists.getInsuranceList().findInsurance(Math.toIntExact(idx)).getPeriod());

		System.out.println("최종 계약 처리되었습니다.");

	}

	public Lists getLists() {
		return this.lists;
	}

	public double findCarRate(int accidentRecord, int carCount, int price) {
		double accidentRate = 1;
		double carCountRate = 1;
		double priceRate = 1;

		if (accidentRecord == 1) {
			accidentRate = 1.3;
		} else if (accidentRecord == 2) {
			accidentRate = 1.5;
		} else if (accidentRecord == 3) {
			accidentRate = 1.8;
		} else {
			accidentRate = 2.2;
		}

		if (carCount == 2) {
			carCountRate = 1.6;
		} else if (carCount == 3) {
			carCountRate = 2.2;
		} else if (carCount == 4) {
			carCountRate = 3;
		} else {
			carCountRate = 4;
		}

		if (price <= 1000) {
			priceRate = 1.1;
		} else if (price <= 4000) {
			priceRate = 1.4;
		} else if (price <= 6000) {
			priceRate = 1.6;
		} else if (price <= 10000) {
			priceRate = 2;
		} else {
			priceRate = 2.6;
		}

		double result = (accidentRate + carCountRate + priceRate) / 3;
		return result;
	}

	public double findFireRate(int buildingCount, int buildingPrice) {
		double buildingCountRate = 1;
		double buildingPriceRate = 1;

		if (buildingCount <= 3) {
			buildingCountRate = 2.2;
		} else if (buildingCount == 5) {
			buildingCountRate = 3;
		} else {
			buildingCountRate = 7;
		}

		if (buildingPrice <= 10000) {
			buildingPriceRate = 1.1;
		} else if (buildingPrice <= 40000) {
			buildingPriceRate = 1.6;
		} else if (buildingPrice <= 60000) {
			buildingPriceRate = 2.4;
		} else if (buildingPrice <= 100000) {
			buildingPriceRate = 3.6;
		} else {
			buildingPriceRate = 5;
		}

		double result = (buildingPriceRate + buildingPriceRate) / 2;
		return result;

	}

	public double findHealthRate(int healthGrade) {
		double healthRate = 1;

		if (healthGrade == 1) {
			healthRate = 1;
		} else if (healthGrade == 2) {
			healthRate = 1.6;
		} else if (healthGrade == 3) {
			healthRate = 3;
		} else if (healthGrade == 4) {
			healthRate = 5.2;
		} else {
			healthRate = 10;
		}

		return healthRate;
	}

	public double findTravelRate(int country, int period) {
		double countryRate = 1;
		double periodRate = 1;

		if (country <= 3) {
			countryRate = 1.4;
		} else if (country <= 5) {
			countryRate = 2;
		} else if (country <= 7) {
			countryRate = 3;
		} else {
			countryRate = 4;
		}

		if (period <= 7) {
			periodRate = 1;
		} else if (period <= 14) {
			periodRate = 1.5;
		} else if (period <= 30) {
			periodRate = 2;
		} else if (period <= 100) {
			periodRate = 3;
		} else {
			periodRate = 5;
		}

		double result = (countryRate + periodRate) / 2;
		return result;

	}
}
