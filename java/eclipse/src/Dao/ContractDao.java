package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import Contract.Contract;

public class ContractDao extends Dao{
	
	public ContractDao() {
		super.connect();
	}
	
    public void addContract(Contract contract) {
		int checkSub = 0;
		int checkSug = 0;
		int checkUw = 0;
		int checkpay = 0;
		if(contract.isCheckSub()) checkSub=1;
		if(contract.isCheckSug()) checkSug=1;
		if(contract.isCheckUw()) checkUw=1;
		if(contract.isCheckPay()) checkpay=1;	
		
		String sql = "INSERT INTO insurance.contract VALUES("+
				"'" + contract.getContractIdx()+ "', "+
				"'" + contract.getCreated()+"', "+
				"'" + contract.getSubscription()+"', "+
				"'" + contract.getSuggestion()+"', "+
				"'" + contract.isCheckPay()+"');";
		
		System.out.println(sql);		
		super.create(sql);
	}

    public List<String> findContractList() {
		String sql = "SELECT * FROM insurance.contract";
		System.out.println(sql);		

		ResultSet rs = super.retrieve(sql);
		System.out.println("Success");		
		List<String> messages = new ArrayList<>();
		
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

			    String message = contractIdx + " " + created +" " +subscription + "" + suggestion + " " + 
					    checkSub + " " + checkSug+ " " + checkUw + " " + checkpay + " " +
					    userIdx + " " + employeeIdx+" " + insuranceIdx+"\n" ;
			    messages.add(message);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return messages;

    }
    public String findOneContract(Long contractIdx) {
		String sql = "SELECT * FROM insurance.contract where contractIdx=" +
				"'"+ contractIdx +"'";
		System.out.println(sql);

		ResultSet rs = super.retrieve(sql);
		String message = null;
		try {
			while(rs.next()) {
				String contractIdx2 = rs.getString(1);
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
			    
			    message = contractIdx + " " + created +" " +subscription + "" + suggestion + " " + 
				    checkSub + " " + checkSug+ " " + checkUw + " " + checkpay + " " +
				    userIdx + " " + employeeIdx+" " + insuranceIdx+"\n" ;
			}
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
    }
    
	public String printSuggestion(Long userIdx) {
		String sql = "SELECT * FROM insurance.contract where userIdx=" +
				"'"+ userIdx +"'";
		ResultSet rs = super.retrieve(sql);
		String message = null;
		try {
			while(rs.next()) {
				String contractIdx = rs.getString(1);
				String suggestion = rs.getString(4);
				String userIdx2 = rs.getString(7);
			    message = contractIdx + " "  + userIdx2 + " "  + suggestion + "\n" ;
			}
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public String printSubscription(Long userIdx) {
		String sql = "SELECT * FROM insurance.contract where userIdx=" +
				"'"+ userIdx +"'";
		ResultSet rs = super.retrieve(sql);
		String message = null;
		try {	
			while(rs.next()) {
				String contractIdx = rs.getString(1);
				String subscription = rs.getString(3);
				String userIdx2 = rs.getString(7);
			    message = contractIdx + " "  + userIdx2 + " "  + subscription + "\n" ;
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	//계약날짜를 바꿔,,? 언제인지 쓸건지.?
	public void modifyContractDate(Long contractIdx) {
	}
	
	public void modifyCheckUw(Long contractIdx) {
		String sql = "update insurance.contract set checkUw="
				+ "'"+ "1" + "', "+ "where contractIdx="
				+ "'" + contractIdx + "'";
		System.out.println(sql);
		super.update(sql);
    }
	
    public void modifyCheckSug(Long userIdx) {
    	String sql = "update insurance.contract set checkSug="
				+ "'"+ "1" + "', "+ "where userIdx="
				+ "'" + userIdx + "'";
		System.out.println(sql);
		super.update(sql);
    }
    
	public void modifyCheckSub(Long userIdx) {	
    	String sql = "update insurance.contract set checkSub="
				+ "'"+ "1" + "', "+ "where userIdx="
				+ "'" + userIdx + "'";
		System.out.println(sql);
		super.update(sql);
	}
	
	//uwStatus = false 조회
	public List<String> getUnCheckList() {
		String sql = "SELECT * FROM insurance.contract where checkUwStatus=" +
				"'"+ "0" +"'";
		ResultSet rs = super.retrieve(sql);
		String message = null;
		List<String> messages = new ArrayList<>();
		try {
			while(rs.next()) {
				String contractIdx = rs.getString(1);
				String contractDate = rs.getString(2);
				String subscription = rs.getString(3);
				String suggestion = rs.getString(4);
				String checkUwStatus = rs.getString(5);
				String checkUw = rs.getString(6);
				String userIdx = rs.getString(7);
				String employeeIdx = rs.getString(8);
				String insuranceIdx = rs.getString(9);
				
				message = contractIdx + " " + contractDate +" " +subscription + "" + suggestion + " " + checkUwStatus + " " + checkUw + " " + userIdx + " " + employeeIdx+" " + insuranceIdx+"\n" ;
				messages.add(message);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;
	}

	 //굳이 필요할까
    public void sendSuggestion(long userIdx, String insuranceType, String content) {
		// 제안서 db저장 userIdx, 보험 종류, 보장내용 저장
	}
    //굳이 필요할까
	public void sendsubscription(long userIdx, String insuranceType, int fee, int period, int mexReward) {
		//청약서 db저장 userIdx, 보험종류, 기본보험료, 기간, 최대보장금액 저장
	}
	
	public void deleteContract(Long contractIdx ) {
		String sql = "delete from insurance.contract where contractIdx=" +
				"'"+ contractIdx +"'";
		System.out.println(sql);		
		super.delete(sql);
	}
}
