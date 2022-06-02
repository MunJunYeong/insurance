package RunClient;

import DataList.Lists;
import Employee.Employee;
import User.User;
import global.Util;

public class PSignUp {
   
   private Lists lists;
   
   public PSignUp(Lists lists) {
      this.lists = lists;

      System.out.println("---------------회원가입---------------");
      int select = Util.IntReader("1.고객 회원가입/2.직원 회원가입");
      if(select == 1) {
         SignUpUser();
      }else if(select == 2) {
         SignUpEmployee();
      }else {
         System.out.println("잘못 입력하였습니다.");
      }            
   }
   public User SignUpUser() {
      User user = new User();
      user.setUserIdx((long)this.lists.getUserList().getUserList().size());
      String id = Util.StringReader("아이디를 입력하세요");
      while(checkUserId(id)) {
         id=Util.StringReader("아이디를 재입력하세요");
      }
      user.setId(id);
      user.setPw(Util.StringReader("비밀번호 입력하세요"));
      user.setName(Util.StringReader("이름을 입력하세요"));
      user.setJob(Util.StringReader("직업를 입력하세요"));
//      user.setSex(Util.StringReader("성별을 입력하세요"));
      user.setSsn(Util.StringReader("주민번호를 입력하세요"));
      user.setTel(Util.StringReader("전화번호를 입력하세요"));
      user.setEmail(Util.StringReader("이메일을 입력하세요"));
      this.lists.getUserList().SignUp(user);
      return user;
   }
   public Employee SignUpEmployee() {
      Employee employee = new Employee();
      employee.setEmployeeIdx((long)this.lists.getEmployeeList().getEmployeeList().size());
      String id = Util.StringReader("아이디를 입력하세요");
      while(checkEmployeeId(id)) {
         id=Util.StringReader("아이디를 재입력하세요");
      }
      employee.setId(Util.StringReader("아이디를 입력하세요"));
      employee.setName(Util.StringReader("이름을 입력하세요"));
      employee.setPw(Util.StringReader("비밀번호 입력하세요"));
      employee.setRole(Util.StringReader("직책을 입력하세요"));
      employee.setTel(Util.StringReader("전화번호를 입력하세요"));
      employee.setAccountNumber(Util.StringReader("전화번호를 입력하세요"));
      this.lists.getEmployeeList().SignUp(employee);
      return employee;
   }   
   public boolean checkUserId(String id) {
      for(int i= 0;i<this.lists.getEmployeeList().getEmployeeList().size();i++) {
         if(this.lists.getEmployeeList().findEmployee(i).getId().equals(id)) {
            System.out.println("중복된 아이디가 있습니다 다시 입력하세요");
            return true;
         }
      }
      return false;
   }
   
   public boolean checkEmployeeId(String id) {
      for(int i= 0;i<this.lists.getUserList().getUserList().size();i++) {
         if(this.lists.getUserList().findUser(i).getId().equals(id)) {
            System.out.println("중복된 아이디가 있습니다 다시 입력하세요");
            return true;
         }
      }
      return false;
   }
	public Lists getLists() {
		return this.lists;
	}
}