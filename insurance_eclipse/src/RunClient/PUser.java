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
         int select = Util.IntReader("5. 로그아웃하기");
         
         switch(select) {
            case 1:
               System.out.println("------제안서를 확인합니다------");
               long idx = -1;
               while(!idxCheck(idx)) {
                  idx = CheckSuggestion(user.getUserIdx());
               }
               if(idx != -2) {
            	   System.out.println(idx + "번의 계약 제안서가 승인되었습니다.");
               }
               break;
            case 2: 
               System.out.println("------청약서를 확인합니다------");
               long idx2 = -1;
               while(!idxCheck(idx2)) {
                  idx2 = CheckSubscription(user.getUserIdx());
               }
               if(idx2 != -2) {
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
         return -2;
      }
      System.out.println("계약번호  " +"고객번호   " +"제안서" );
      for(Contract contract : contractList) {
         String message = contract.getContractIdx() + "      " + contract.getUserIdx() + "       " + contract.getSuggestion();
         System.out.println(message);
      }
      //여기서부터 제안서에 대한 승인 내용
      int contractIdx = Util.IntReader("승인하실 계약 번호를 입력해주세요");
      int suggestionChoice = Util.IntReader("승인하시겠습니까? 승인(1) 미승인(2)");
      if (suggestionChoice == 1) {
         Contract contract = new Contract();
         for(Contract temp : contractList) {
            if(temp.getContractIdx() == contractIdx) {
               contract = temp;
            }
         }
         this.lists.modifyCheckSug(contract.getContractIdx());
         return contract.getContractIdx();
      }else if(suggestionChoice==2){
         System.out.println("미승인 처리 되었습니다.");
         return -1;
      }else {
         System.out.println("1또는2를 입력해주십시오.");
         return 0;
      }
   }
   public long CheckSubscription(Long userIdx) {
      List<Contract> contractList = this.lists.getUserContract(userIdx);
      if(contractList.size() == 0) {
         System.out.println("요청 온 청약서가 존재하지 않습니다.");
         System.out.println();
         return -2;
      }
      String message = null;
      System.out.println("계약번호  " +"고객번호   " +"청약서" );
      for(Contract contract : contractList) {
         message = contract.getContractIdx() + "       " + contract.getUserIdx() + "       " + contract.getSubscription();
         System.out.println(message);
      }
      //여기서부터 청약서에 대한 승인 내용
      int contractIdx = Util.IntReader("승인하실 계약 번호를 입력해주세요");
      int subscriptionChoice = Util.IntReader("승인하시겠습니까? 승인(1) 미승인(2)");
      if (subscriptionChoice == 1) {
         Contract contract = null;
         for(Contract temp : contractList) {
            if(temp.getContractIdx() == contractIdx) {
               contract = temp;
            }
         }
         System.out.println("승인 처리 되었습니다.");
         this.lists.modifyCheckSub(contract);
         return contract.getContractIdx();
      }else if(subscriptionChoice ==2 ){
         System.out.println("미승인 처리 되었습니다.");
         return -1;
      }else {
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
      while(!flag) {
    	  int type = Util.IntReader("화재(1), 자동차(2), 생명(3), 여행(4)");
    	  switch(type) {
    	  case 1:
    		  insuranceList = this.lists.getUserFireList(this.user.getUserIdx());
    		  accident.setAccidenttype("Fire");
    		  if(insuranceList == null) 
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
    	  default :
    		  System.out.println("올바른 번호를 입력해주세요.");
    		  break;
    	  }
      }
      if(insuranceList.size() == 0) {
    	  System.out.println("고객님께서 가입한 보험이 존재하지 않아 사고 신고가 불가능합니다.");
    	  return false;
      }
      //사실 여기서 보험 리스트를 보여주는 것이 옳으나 그냥 제일 위에있는 보험으로 자동 연계되어 들어간다 ?
      
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
	   if(idx == -1)return false;
      return true;
   }
}