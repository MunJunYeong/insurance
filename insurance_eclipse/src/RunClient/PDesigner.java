package RunClient;

import DataList.Lists;
import Employee.Employee;
import Insurance.Car;
import Insurance.Fire;
import Insurance.Health;
import Insurance.Insurance;
import Insurance.Travel;
import global.Util;

public class PDesigner {

	private Employee employee;
	private Lists lists;

	public PDesigner(Employee employee, Lists lists) {
		this.employee = employee;
		this.lists = lists;

		// Designer 상품 개발자
		DesignerMain();
	}

	public void DesignerMain() {
		boolean check = false;
		while (!check) {
			System.out.println("---------------UW---------------");
			System.out.println("1. 화재 보험 개발하기");
			System.out.println("2. 실손 의료비 보험 개발하기");
			System.out.println("3. 자동차 보험 개발하기");
			System.out.println("4. 여행 보험 개발하기");
			int select = Util.IntReader("5.exit");
			if (select <= 4 && select > 0) {
				this.lists.getInsuranceList().CreateInsurance(CreateInsurance(select));
			} else if (select == 5) {
				check = true;
			} else {
				System.out.println("Select Error retry");
			}
		}
	}

	public Insurance CreateInsurance(int number) {
		int employeeidx;
		return null;
//		switch (number) {
//		case 1:
//			Fire fire = new Fire();
//			fire.setInsuranceIdx((long) this.lists.getInsuranceList().getInsuranceList().size());
//			fire.setBuildingCount(Util.IntReader("건물개수: "));
//			fire.setBuildingPrice(Util.IntReader("건물가격: "));
//			fire.setContent(Util.StringReader("내용: "));
//			fire.setFee(Util.IntReader("요금: "));
//			fire.setMaxReward(Util.IntReader("최대 보상금: "));
//			fire.setPeriod(Util.IntReader("기간: "));
//			fire.setRate(1);
//			employeeidx = Util.IntReader("직원번호: ");
//			fire.setEmployeeIdx(employeeidx);
//			fire.setEmployee(this.lists.getEmployeeList().findEmployee(employeeidx));
//			return fire;
//		case 2:
//			Health health = new Health();
//			health.setType("Health");
//			health.setInsuranceIdx((long) this.lists.getInsuranceList().getInsuranceList().size());
//			health.setHealthGrade(Util.IntReader("건강 등급: "));
//			health.setContent(Util.StringReader("내용: "));
//			health.setFee(Util.IntReader("요금: "));
//			health.setMaxReward(Util.IntReader("최대 보상금: "));
//			health.setPeriod(Util.IntReader("기간: "));
//			health.setRate(1);
//			employeeidx = Util.IntReader("직원번호: ");
//			health.setEmployeeIdx(employeeidx);
//			health.setEmployee(this.lists.getEmployeeList().findEmployee(employeeidx));
//			return health;
//		case 3:
//			Car car = new Car();
//			car.setType("Car");
//			car.setInsuranceIdx((long) this.lists.getInsuranceList().getInsuranceList().size());
//			car.setAccidentRecord(Util.IntReader("사고횟수: "));
//			car.setCarCount(Util.IntReader("보유 차 대수: "));
//			car.setCarNo(Util.StringReader("차 번호: "));
//			car.setPrice(Util.IntReader("차 가격: "));
//			car.setContent(Util.StringReader("내용: "));
//			car.setFee(Util.IntReader("요금: "));
//			car.setMaxReward(Util.IntReader("최대 보상금: "));
//			car.setPeriod(Util.IntReader("기간: "));
//			car.setRate(1);
//			employeeidx = Util.IntReader("직원번호: ");
//			car.setEmployeeIdx(employeeidx);
//			car.setEmployee(this.lists.getEmployeeList().findEmployee(employeeidx));
//			return car;
//		case 4:
//			Travel travel = new Travel();
//			travel.setType("Travel");
//			travel.setInsuranceIdx((long) this.lists.getInsuranceList().getInsuranceList().size());
//			travel.setCountry(Util.IntReader("도시등급: "));
//			travel.setTravelPeriod(Util.IntReader("여행기간: "));
//			travel.setContent(Util.StringReader("내용: "));
//			travel.setFee(Util.IntReader("요금: "));
//			travel.setMaxReward(Util.IntReader("최대 보상금: "));
//			travel.setPeriod(Util.IntReader("기간: "));
//			travel.setRate(1);
//			employeeidx = Util.IntReader("직원번호: ");
//			travel.setEmployeeIdx(employeeidx);
//			travel.setEmployee(this.lists.getEmployeeList().findEmployee(employeeidx));
//			return travel;
//		default:
//			System.out.println("--------존재하지 않는 항목입니다---------");
//			return null;
//		}
	}

	public Lists getLists() {
		return this.lists;
	}
}