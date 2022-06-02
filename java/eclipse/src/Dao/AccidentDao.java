package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Accident.Accident;

public class AccidentDao extends Dao{

	public AccidentDao() {
		super.connect();
	}
	
	public void addAccident(Accident accident) {
		int isCheckAccident = 0;
		int isLawsuitStatus = 0;
		if(accident.isCheckAccident()) isCheckAccident=1;
		if(accident.isLawsuitStatus()) isLawsuitStatus=1;
		String sql = "INSERT INTO insurance.accident(accidenttype, content, accidentDate, damagePrice)"
				+ " VALUES("+
						"'" + accident.getAccidenttype()+"', "+
						"'" + accident.getContent()+"', "+
						"'" + accident.getAccidentDate()+"', "+
						"'" + accident.getDamagePrice()+"');";

		System.out.println(sql);		
		super.create(sql);
	}
	
	public List<String> getAccidentList() {
		String sql = "SELECT * FROM insurance.accident";
		System.out.println(sql);		

		ResultSet rs = super.retrieve(sql);
		System.out.println("Success");		
		List<String> messages = new ArrayList<>();
		
		try {
			while(rs.next()) {
			    String idx = rs.getString(1);
			    String type = rs.getString(2);
			    String content = rs.getString(3);
			    String accidentDate = rs.getString(4);
			    String damagePrice = rs.getString(5);
			    String compensationPrice = rs.getString(6);
//			    String userIdx = rs.getString(7);
//			    String insuranceIdx = rs.getString(8);
//			    String employeeIdx = rs.getString(9);
			    String checkAccident = rs.getString(10);
			    String  lawsuitStaus = rs.getString(11);

			    String message = idx+ " " + type + " " + content +" " +accidentDate + "" + damagePrice + " " + compensationPrice + " " + checkAccident + " " + lawsuitStaus + "\n" ;
			    messages.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;
    }
	
	public String findOneAccident(Long accidentIdx) {
		String sql = "SELECT * FROM insurance.accident where accidentIdx=" +
					"'"+ accidentIdx +"'";
		System.out.println(sql);
		ResultSet rs = super.retrieve(sql);
		
		String message = null;
		try {
			while(rs.next()) {
			    String idx = rs.getString(1);
			    String type = rs.getString(2);
			    String content = rs.getString(3);
			    String accidentDate = rs.getString(4);
			    String damagePrice = rs.getString(5);
			    String compensationPrice = rs.getString(6);
//			    String userIdx = rs.getString(7);
//			    String insuranceIdx = rs.getString(8);
//			    String employeeIdx = rs.getString(9);
			    String checkAccident = rs.getString(10);
			    String  lawsuitStaus = rs.getString(11);
			    
			    message = idx+" " + type + " " + content +" " +accidentDate + "" + damagePrice + " " + compensationPrice + " " + checkAccident + " " + lawsuitStaus + "\n" ;
			    
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
    }
	
	 public void modifyCompensation(Long accidentIdx, int compensationPrice) {
			String sql = "update insurance.accident set compensationPrice="
					+ "'"+ compensationPrice + "' "+ "where accidentIdx="
					+ "'" + accidentIdx + "';";
			System.out.println(sql);
			super.update(sql);
	 }
	 
	 public void modifyCheckAccident(Long accidentIdx) {
		 //사고 체크
		String sql = "update insurance.accident set checkAccident="
				+ "'"+ "1" + "' "+ "where accidentIdx="
				+ "'" + accidentIdx + "'";
		System.out.println(sql);
		super.update(sql);
	 }
	   
	 public void modifyLawsuit(Long accidentIdx) {
		 //소송 여부
		String sql = "update insurance.accident set lawsuitStatus="
				+ "'"+ "1" + "', "+ "where accidentIdx="
				+ "'" + accidentIdx + "'";
		System.out.println(sql);
		super.update(sql);
	 }
	 
	public List<String> getcalculatedAccident() {
	//db에서 보상 산정 완료된 리스트 가져오기
		String sql = "SELECT * FROM insurance.accident where compensationPrice=" 
					+ "'" + null + "'";
		System.out.println(sql);
		
		ResultSet rs = super.retrieve(sql);
		String message = null;
		List<String> messages = new ArrayList<>();
		try {
			while(rs.next()) {
			    String idx = rs.getString(1);
			    String type = rs.getString(2);
			    String content = rs.getString(3);
			    String accidentDate = rs.getString(4);
			    String damagePrice = rs.getString(5);
			    String compensationPrice = rs.getString(6);
			    String checkAccident = rs.getString(7);
			    String  lawsuitStaus = rs.getString(8);
			    
			    message = type + " " + content +" " +accidentDate + "" + damagePrice + " " + compensationPrice + " " + checkAccident + " " + lawsuitStaus + "\n" ;
			    messages.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;			
	}
	
	//****** 보상지급	,,? *******
	private void rewardCompensation(long userIdx, int compensationPrice) {
		String sql = null ;
		System.out.println(sql);
		super.update(sql);
 }
	
	
	//이게 뭐야
	//userIdx 조회시 보상 기록 조회
	public String getRewardRecord(Long userIdx) {
		String sql = "SELECT * FROM insurance.accident where userIdx=" +
				"'"+ userIdx +"'";
		
		ResultSet rs = super.retrieve(sql);
		String message = null;
		try {
			while(rs.next()) {
			    String idx = rs.getString(1);
			    String damagePrice = rs.getString(5);
			    String compensationPrice = rs.getString(6);
				message = idx+ " "+ "\n" + "손상금액: " + damagePrice + "\n" + "보상금액: "+compensationPrice +  "\n" ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return message;
	}
	
	public void deleteAccident(Long accidentIdx ) {
		String sql = "delete from insurance.accident where accidentIdx=" +
				"'"+ accidentIdx +"'";
		System.out.println(sql);		
		super.delete(sql);
	}
}
