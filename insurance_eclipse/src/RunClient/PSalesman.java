package RunClient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import Contract.Contract;
import DataList.Lists;
import Employee.Employee;
import Insurance.Car;
import Insurance.Fire;
import Insurance.Health;
import Insurance.Insurance;
import Insurance.Travel;
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
			System.out.println();
			System.out.println(this.employee.getName() + "님이 접속했습니다.");
			System.out.println("1. 고객 리스트 확인하기");
			System.out.println("2. 최종 계약 리스트  승인하기");
			System.out.println("3. 완성 계약 리스트 확인하기");
			int select = Util.IntReader("4. 로그아웃");
			
			switch (select) {
			case 1:
				CheckUserList();
				break;
			case 2:
				ShowFinalContract();
				break;
			case 3:
				showCompleteContract();
				break;
			case 4:
				check = true;
				break;
			default :
				System.out.println("Select Error retry");
			}
		}
	}

	

	// 1번 클릭시
	public void CheckUserList() {
		List<User> userList = this.lists.getUserList();
		User user = null;
		int userIdx = 0;
		System.out.println("---------------User List---------------");
		StringBuilder sb = new StringBuilder();

		if (userList.size() == 0) {
			System.out.println("고객이 존재하지 않습니다.");
			return;
		}
		for (int i = 0; i < userList.size(); i++) {
			User temp = userList.get(i);
			sb.append("[UserIdx: " + temp.getUserIdx() + "] ").append("[이름: " + temp.getName() + "] ")
			.append("[이메일: " + temp.getEmail() + "] ").append("[직업: " + temp.getJob() + "]\n");
		}
		System.out.print(sb);
		System.out.println("---------------Select---------------");
		// next
		boolean checkUser = false;
		while (!checkUser) {
			userIdx = Util.IntReader("제안서와 청약서를 작성할 고객 번호를 입력해주세요.\n(전으로 돌아가려면, 0을 입력하세요)");
			if (userIdx == 0)
				return;
			for (User temp : userList) {
				if (temp.getUserIdx() == userIdx) {
					checkUser = true;
					user = temp;
				}
			}
			if (user == null)
				System.out.println("존재하지 않는 유저 idx 입니다.");
		}
		// userIdx가 존재하는지도 체크해주는 validation 추가하기
		int temp = -1;
		do {
			int insuranceType = Util.IntReader("제안할 보험 종류를 선택해주세요. 화재(1), 자동차(2), 건강(3), 여행(4)");
			temp = printInsurace(insuranceType);
		} while (temp == -1);

		int insuranceIdx = Util.IntReader("보험 번호를 입력해주세요.");
		String suggestion = Util.StringReader("제안서 내용을 입력해주세요.");
		String subscription = Util.StringReader("청약서 내용을 입력해주세요.");

		Contract contract = new Contract();
		contract.setUserIdx((long) userIdx);
		contract.setSuggestion(suggestion);
		contract.setSubscription(subscription);
		contract.setInsuranceIdx((long) insuranceIdx);
		contract.setEmployeeIdx(employee.getEmployeeIdx());
		String dateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate time = LocalDate.parse(dateString);
		contract.setCreated(time);
		this.lists.addContract(contract);
		// 만약 청약서 제안서 따로 작성을 원한다면 제안서 저장후 리스트에 저장하는데 청약서 작성할때 만약 기존 작성이 잇다면 이어서 해야하고 없으면
		// 청약서 작성을 막아야함.
	}

	   private int printInsurace(int insuranceType) {
		      boolean flag = false;
		      while(!flag) {
		         switch(insuranceType) {
		         case 1 :
		            List<Fire> fireList = this.lists.getFireList();
		            if(fireList.size() != 0) {
		               for(Insurance insurance : fireList) {
		                  System.out.println(insurance.getInsuranceIdx() + "  "+ insurance.getRate()
		                  + "  "+ insurance.getFee());
		               }
		               flag = true;
		            }else {
		               System.out.println("보험이 아직 개발되지 않았습니다.");
		               return -1;
		            }
		            break;
		         case 2 :
		            List<Car> carList = this.lists.getCarList();
		            if(carList.size() != 0) {
		               for(Insurance insurance : carList) {
		                  System.out.println(insurance.getInsuranceIdx() + "  "+ insurance.getRate()
		                  + "  "+ insurance.getFee());
		               }
		               flag = true;
		            }else {
		               System.out.println("보험이 아직 개발되지 않았습니다.");
		               return -1;
		            }
		            break;
		         case 3 :
		            List<Health> healthList = this.lists.getHealthList();
		            if(healthList.size() != 0) {
		               for(Insurance insurance : healthList) {
		                  System.out.println(insurance.getInsuranceIdx() + "  "+ insurance.getRate()
		                  + "  "+ insurance.getFee());
		               }
		               flag = true;
		            }else {
		               System.out.println("보험이 아직 개발되지 않았습니다.");
		               return -1;
		            }
		            break;
		         case 4 :
		            List<Travel> travelList = this.lists.getTravelList();
		            if(travelList.size() != 0) {
		               for(Insurance insurance : travelList) {
		                  System.out.println(insurance.getInsuranceIdx() + "  "+ insurance.getRate()
		                  + "  "+ insurance.getFee());
		               }
		               flag = true;
		            }else {
		               System.out.println("보험이 아직 개발되지 않았습니다.");
		               return -1;
		            }
		            break;
		         default :
		            flag = true;
		            System.out.println("다시 번호를 입력해주세요.");            
		            break;
		         }
		      }
		      return 1;
		   }

	// 2번 클릭
	public void ShowFinalContract() {
		System.out.println("---------------Final Contract List---------------");
		List<Contract> contractList = this.lists.getFinalContract();
		if(contractList.size() == 0) {
			System.out.println("인수 검사를 시행한 계약이 아직 존재하지 않습니다."); return;
		}
		for(Contract contract : contractList) {
			System.out.println(contract.getContractIdx() + "   "+ contract.getUserIdx()  + "   "+ 
					contract.getEmployeeIdx()
			);
		}
		int contractIdx = Util.IntReader("최종 승인할 계약 번호를 입력해주세요.");
		//contractIdx validation
		this.lists.modifyCompleted((long) contractIdx);
		//여기서 보험을 가지고와서 rate period fee 가지고오기
		System.out.println("최종 계약 처리되었습니다.");
		System.out.println();
	}
	private void showCompleteContract() {
		System.out.println("---------------Complete Contract List---------------");
		List<Contract> contractList = this.lists.getCompleteContract();
		if(contractList.size() == 0) {
			System.out.println("최종 계약 완료된 보험 계약이 아직 존재하지 않습니다."); return;
		}
		for(Contract contract : contractList) {
			System.out.println(contract.getContractIdx() + "   "+ contract.getUserIdx()  + "   "+ 
					contract.getEmployeeIdx()
			);
		}
		System.out.println();
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
