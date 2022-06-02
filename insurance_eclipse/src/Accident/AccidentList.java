package Accident;

import java.sql.ResultSet;

public interface AccidentList {

	public boolean createAccident(Accident accident);
	public ResultSet getAccidentList();
	public ResultSet findAccident(Long accidentIdx);
	public boolean deleteAccident(Long accidentIdx);
}
