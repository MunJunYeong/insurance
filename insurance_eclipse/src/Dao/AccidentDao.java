package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Accident.Accident;

public class AccidentDao extends Dao{

	public AccidentDao() {
		super.connect();
	}
	
	public boolean addAccident(Accident accident) {
		int isCheckAccident = 0;
		int isLawsuitStatus = 0;
		if(accident.isCheckAccident()) isCheckAccident=1;
		if(accident.isLawsuitStatus()) isLawsuitStatus=1;
		LocalDate now = LocalDate.now();
		String sql = "INSERT INTO insurance.accident(accidenttype, content, accidentDate, damagePrice)"
				+ " VALUES("+
						"'" + accident.getAccidenttype()+"', "+
						"'" + accident.getContent()+"', "+
						"'" + now +"', "+
						"'" + accident.getDamagePrice()+"');";
		return super.create(sql);
	}
	
	public List<Accident> getAccidentList() {
		String sql = "SELECT * FROM insurance.accident";
		ResultSet rs = super.retrieve(sql);
		List<Accident> accidentLists = new ArrayList<>();
		boolean bolcheckAccident = true;
		boolean bollawsuitStatus = true;

		try {
			while(rs.next()) {
			    String idx = rs.getString(1);
			    String type = rs.getString(2);
			    String content = rs.getString(3);
			    String accidentDate = rs.getString(4);
			    String damagePrice = rs.getString(5);
			    String compensationPrice = rs.getString(6);
			    String userIdx = rs.getString(7);
			    String insuranceIdx = rs.getString(8);
			    String employeeIdx = rs.getString(9);
			    String checkAccident = rs.getString(10);
			    String  lawsuitStaus = rs.getString(11);
			    
			    if(checkAccident.equals("0")) {
			    	bolcheckAccident= false;
			    }
			    if(lawsuitStaus.equals("0")) {
			    	bollawsuitStatus= false;
			    }

			    Accident accident = new Accident();
			    accident.setAccidentIdx(Long.parseLong(idx));
			    accident.setAccidenttype(type);
			    accident.setContent(content);
			    accident.setAccidentDate(LocalDate.parse(accidentDate, DateTimeFormatter.ISO_DATE));
			    accident.setDamagePrice(Integer.parseInt(damagePrice));
			    accident.setCompensationPrice(Integer.parseInt(compensationPrice));
			    accident.setUserIdx(Long.parseLong(userIdx));
			    accident.setInsuranceIdx(Long.parseLong(insuranceIdx));
			    accident.setEmployeeIdx(Long.parseLong(employeeIdx));
			    accident.setCheckAccident(bolcheckAccident);
			    accident.setLawsuitStatus(bollawsuitStatus);
			    
			    accidentLists.add(accident);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accidentLists;
    }

	public boolean deleteAccident(Long accidentIdx ) {
		String sql = "delete from insurance.accident where accidentIdx=" +
				"'"+ accidentIdx +"'";
		return super.delete(sql);
	}
	
	
	
}