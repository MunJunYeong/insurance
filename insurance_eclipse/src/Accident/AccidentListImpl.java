package Accident;

import java.sql.ResultSet;
import java.util.List;

import Dao.AccidentDao;

public class AccidentListImpl implements AccidentList {

	private AccidentDao accidentDao = new AccidentDao();

	public AccidentListImpl() {
	}
	
	public ResultSet getAccidentList() {
		ResultSet accidentLists = accidentDao.getAccidentList();
		return accidentLists;
	}

	public ResultSet findAccident(Long accidentIdx) {
		ResultSet foundaccident = accidentDao.findOneAccident(accidentIdx);
		return foundaccident;
	}

	public boolean createAccident(Accident accident) {
		return accidentDao.addAccident(accident);
	}

	public boolean deleteAccident(Long accidentIdx) {
		return accidentDao.deleteAccident(accidentIdx);
	}
}
