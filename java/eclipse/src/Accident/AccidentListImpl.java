package Accident;

import java.util.ArrayList;

public class AccidentListImpl implements AccidentList {

	private ArrayList<Accident> accidentList;

	public AccidentListImpl() {
		this.accidentList = new ArrayList<Accident>();
	}
	
	public ArrayList<Accident> getAccidentList() {
		
		return this.accidentList;
	}

	public Accident findAccident(int idx) {
		return this.accidentList.get(idx);
	}

	public boolean CreateAccident(Accident accident) {
		this.accidentList.add(accident);
		return true;
	}
}
