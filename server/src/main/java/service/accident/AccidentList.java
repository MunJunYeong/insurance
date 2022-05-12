package service.accident;

import domain.Accident;

import java.util.ArrayList;

public interface AccidentList {
    public ArrayList<Accident> findAccidentList();
    public Accident findAccident();

}
