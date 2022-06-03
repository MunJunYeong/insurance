package Dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Contract.Contract;

public class ContractDao extends Dao{
	public ContractDao() {
		super.connect();
	}

    public boolean addContract(Contract contract) {
		int checkSub = 0;
		int checkSug = 0;
		int checkUw = 0;
		int checkPay = 0;
		
		String sql = "INSERT INTO insurance.contract(created, subScription, suggestion, userIdx, employeeIdx, insuranceIdx) VALUES("+
				"'" + contract.getCreated()+"', "+
				"'" + contract.getSubscription()+"', "+
				"'" + contract.getSuggestion()+"', "+
				"'" + contract.getUserIdx()+"', "+
				"'" + contract.getEmployeeIdx()+"', "+
				"'" + contract.getInsuranceIdx()+"');";
		return super.create(sql);
	}

    public List<Contract> findContractList() {
		String sql = "SELECT * FROM insurance.contract";
		ResultSet rs = super.retrieve(sql);
		List<Contract> contractList = new ArrayList<>();
		boolean bolCheckSub = true;
		boolean bolCheckSug = true;
		boolean bolCheckUw = true;
		boolean bolCheckpay = true;
		boolean bolCompleted = true;
		try {
			while(rs.next()) {
				String contractIdx = rs.getString(1);
				String created = rs.getString(2);
				String subscription = rs.getString(3);
				String suggestion = rs.getString(4);
				String checkSub = rs.getString(5);
				String checkSug = rs.getString(6);
				String checkUw = rs.getString(7);
				String checkpay = rs.getString(8);
				String userIdx = rs.getString(9);
				String employeeIdx = rs.getString(10);
				String insuranceIdx = rs.getString(11);
				String completed = rs.getString(12);
			    if(checkSub.equals("0")) bolCheckSub= false;
			    if(checkSug.equals("0")) bolCheckSug= false;
			    if(checkUw.equals("0"))  bolCheckUw= false;
			    if(checkpay.equals("0")) bolCheckpay= false;
			    if(completed.equals("0")) bolCompleted= false;

				Contract contract = new Contract();
				contract.setContractIdx(Long.parseLong(contractIdx));
				String dateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
				LocalDate time =LocalDate.parse(dateString);
				contract.setCreated(time);
				contract.setSubscription(subscription);
				contract.setSuggestion(suggestion);
				contract.setCheckSub(bolCheckSub);
				contract.setCheckSug(bolCheckSug);
				contract.setCheckUw(bolCheckUw);
				contract.setCheckPay(bolCheckpay);
				System.out.println(Long.parseLong(userIdx));
				contract.setUserIdx(Long.parseLong(userIdx));
				contract.setEmployeeIdx(Long.parseLong(employeeIdx));
				contract.setInsuranceIdx(Long.parseLong(insuranceIdx));
				contract.setCompleted(bolCompleted);
				contractList.add(contract);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return contractList;
    }

	public boolean deleteContract(Long contractIdx ) {
		String sql = "delete from insurance.contract where contractIdx=" +
				"'"+ contractIdx +"'";
		return super.delete(sql);
	}
}	   