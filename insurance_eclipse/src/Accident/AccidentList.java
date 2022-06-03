package Accident;

 

import java.util.List;

 

public interface AccidentList {

	public boolean createAccident(Accident accident);
	public List<Accident> getAccidentList();
	public boolean deleteAccident(Long accidentIdx);
	
}

 

 