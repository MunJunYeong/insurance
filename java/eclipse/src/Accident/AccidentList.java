package Accident;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface AccidentList {

	public boolean CreateAccident(Accident accident);
	public ArrayList<Accident> getAccidentList();
	public Accident findAccident(int idx);
}
