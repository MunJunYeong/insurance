package service.employee;

import domain.Employee;

import java.util.ArrayList;

public interface EmployeeList {
    //보험 설계사 리스트 가져오기(파라미터로 role에 해당하는 string 넣어주기
    public ArrayList<Employee> findSalesmanList();


}
